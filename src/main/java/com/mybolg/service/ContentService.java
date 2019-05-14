package com.mybolg.service;

import com.github.pagehelper.PageInfo;
import com.mybolg.modal.vo.ContentVo;
import com.mybolg.modal.vo.ContentVoExample;

public interface ContentService {

    /**
     * 发布文章
     * @param contentVos
     */
    void publish(ContentVo contentVo);

    /**
     * 删除文章
     * @param articleId
     */
    void delArticle(Integer articleId);

    /**
     * 编辑文章
     * @param contentVo
     */
    void modifyArticle(ContentVo contentVo);

    /**
     * 分页获取文章
     * @param contentVo
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ContentVo> getArticles(ContentVoExample contentVoExample, Integer page, Integer limit);

    /**
     * 通过cid获取文章
     * @return
     */
    ContentVo getArticleByCid(String cid);

    /**
     * 检索
     * @param keyword
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ContentVo> retrievalArticles(String keyword, Integer page, Integer limit);
}
