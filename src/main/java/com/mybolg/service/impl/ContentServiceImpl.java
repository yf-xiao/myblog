package com.mybolg.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybolg.constant.WebConst;
import com.mybolg.dao.ContentVoMapper;
import com.mybolg.dao.MetaVoMapper;
import com.mybolg.exception.TipException;
import com.mybolg.modal.vo.ContentVo;
import com.mybolg.modal.vo.ContentVoExample;
import com.mybolg.modal.vo.MetaVo;
import com.mybolg.modal.vo.MetaVoExample;
import com.mybolg.service.ContentService;
import com.mybolg.util.DateTimeUtil;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentVoMapper contentVoMapper;

    @Autowired
    MetaVoMapper metaVoMapper;

    @Override
    public void publish(ContentVo contentVo) {
        
        contentVo.setCreated(DateTimeUtil.getCurrentUnixTime());
        contentVo.setModified(DateTimeUtil.getCurrentUnixTime());
        contentVo.setHits(0);
        contentVo.setCommentsNum(0);
        contentVoMapper.insert(contentVo);

        if (contentVo.getCategories().split(",").length > 0) {
            for(String categoryName : contentVo.getCategories().split(",")) {
                MetaVoExample metaVoExample = new MetaVoExample();
                metaVoExample.createCriteria().andNameEqualTo(categoryName);
                metaVoExample.createCriteria().andTypeEqualTo("category");

                List<MetaVo> list = metaVoMapper.selectByExample(metaVoExample);

                if (list.size() > 0) {
                    list.get(0).setSort(list.get(0).getSort() + 1);
                    metaVoMapper.updateByPrimaryKey(list.get(0));
                }
            }
        }
    }

    @Override
    public void delArticle(Integer articleId) {
        contentVoMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public void modifyArticle(ContentVo contentVo) {
        // TODO Auto-generated method stub

    }

    @Override
    public PageInfo<ContentVo> getArticles(ContentVoExample contentVoExample, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ContentVo> articles = contentVoMapper.selectByExample(contentVoExample);
        return new PageInfo<>(articles);
    }

    @Override
    public ContentVo getArticleByCid(String cid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PageInfo<ContentVo> retrievalArticles(String keyword, Integer page, Integer limit) {
        // TODO Auto-generated method stub
        return null;
    }

}
