package com.mybolg.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.mybolg.constant.WebConst;
import com.mybolg.exception.TipException;
import com.mybolg.modal.bo.RestResponseBo;
import com.mybolg.modal.vo.ContentVo;
import com.mybolg.modal.vo.ContentVoExample;
import com.mybolg.modal.vo.MetaVo;
import com.mybolg.modal.vo.MetaVoExample;
import com.mybolg.modal.vo.UserVo;
import com.mybolg.service.ContentService;
import com.mybolg.service.MetaService;
import com.mybolg.util.SessionUtil;

@Controller
@RequestMapping(value = "/admin/article")
public class ArticleController {

    @Autowired
    MetaService metaService;

    @Autowired
    ContentService contentService;

    @GetMapping(value = "/publish")
    public String toPublish(HttpServletRequest request) {
        List<MetaVo> categories = metaService.getMetas("category");
        request.setAttribute("categories", categories);
        return "admin/article_edit";
    }

    @PostMapping(value = "/publish")
    @ResponseBody
    public RestResponseBo publishArticle(HttpServletRequest request, ContentVo contentVo) {
        if (StringUtils.isBlank(contentVo.getTitle())) {
            throw new TipException("标题为空");
        } else if (contentVo.getTitle().length() > WebConst.MAX_TITLE_COUNT) {
            throw new TipException("文章标题过长");
        }

        UserVo userVo = SessionUtil.getLoginUser(request);

        if (userVo == null) {
            return RestResponseBo.fail("请先登录后在进行操作");
        }

        if (StringUtils.isNotBlank(contentVo.getTags()) && contentVo.getTags().split(",").length > 0) {
            for (String tag : contentVo.getTags().split(",")) {
                //已经存在就引用加一,否则新增
                MetaVo metaVo = metaService.getMetaForMetaName(tag);
                if (metaVo != null) {
                    metaVo.setSort(metaVo.getSort() + 1);
                    metaService.modifyMetas(metaVo);
                } else {
                    metaVo = new MetaVo();
                    metaVo.setSort(1);
                    metaVo.setType("tag");
                    metaVo.setName(tag);
                    metaVo.setSlug(tag);
                    metaService.addMeta(metaVo);
                }
            }
        }

        contentVo.setAuthorId(userVo.getUid());
        contentVo.setType("article");
        contentVo.setCategories(StringUtils.isNotBlank(contentVo.getCategories()) ? contentVo.getCategories() : "默认分类");

        contentService.publish(contentVo);

        return RestResponseBo.ok();
    }

    @GetMapping(value = "")
    public String articleList(HttpServletRequest request,
                @RequestParam(value = "page", defaultValue = "1") int page,
                @RequestParam(value = "limit", defaultValue = "7") int limit) {
        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.createCriteria().andStatusEqualTo("publish");
        PageInfo<ContentVo> articles = contentService.getArticles(contentVoExample, page, limit);
        request.setAttribute("articles", articles);
        return "admin/article_list";
    }

    @PostMapping(value = "/delArticle")
    @ResponseBody
    @Transactional
    public RestResponseBo delArticle(Integer cid) {
        try {
            contentService.delArticle(cid);
        } catch (Exception e) {
            throw new TipException("删除失败");
        }
        return RestResponseBo.ok();
    }
}
