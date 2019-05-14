package com.mybolg.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybolg.modal.bo.RestResponseBo;
import com.mybolg.modal.vo.MetaVo;
import com.mybolg.service.MetaService;

@Controller
@RequestMapping(value = "/admin/category")
public class MetasController {

    @Autowired
    MetaService metaService;

    @GetMapping(value = "")
    public String category(HttpServletRequest request) {
        List<MetaVo> metas = metaService.getMetas(null);
        List<MetaVo> categories = new ArrayList<>();
        List<MetaVo> tags = new ArrayList<>();
        for (MetaVo metaVo : metas) {
            if (StringUtils.equalsIgnoreCase(metaVo.getType(), "tag")) {
                tags.add(metaVo);
            } else {
                categories.add(metaVo);
            }
        }

        request.setAttribute("categories", categories);
        request.setAttribute("tags", tags);
        return "/admin/categories";
    }

    @PostMapping(value = "/saveCategory")
    @ResponseBody
    public RestResponseBo saveCategory(Integer mid, String category, String tag) {

        if (mid != null && mid != 0) {
            MetaVo metaVo = metaService.getMetaForMid(mid);

            if (StringUtils.isNotBlank(category)) {
                if (metaService.getMetaForMetaName(category) != null) {
                    return RestResponseBo.fail("分类已存在");
                }

                metaVo.setName(category);
            } else {
                if (metaService.getMetaForMetaName(tag) != null) {
                    return RestResponseBo.fail("标签已存在");
                }

                metaVo.setName(tag);
            }

            metaService.modifyMetas(metaVo);
        } else {

            MetaVo metaVo = new MetaVo();
            metaVo.setSort(0);

            if (StringUtils.isNotBlank(category)) {
                if (metaService.getMetaForMetaName(category) != null) {
                    return RestResponseBo.fail("分类已存在");
                }

                metaVo.setType("category");
                metaVo.setName(category);
                metaVo.setSlug(category);
            } else {
                if (metaService.getMetaForMetaName(tag) != null) {
                    return RestResponseBo.fail("标签已存在");
                }

                metaVo.setType("tag");
                metaVo.setName(tag);
                metaVo.setSlug(tag);
            }

            metaService.addMeta(metaVo);
        }

        return RestResponseBo.ok();
    }
}
