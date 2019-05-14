package com.mybolg.service;

import com.github.pagehelper.PageInfo;
import com.mybolg.modal.vo.CommentVo;
import com.mybolg.modal.vo.CommentVoExample;

public interface CommentService {

    /**
     * 获取评论
     * @param commentVo
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CommentVo> getComments(CommentVo commentVo, Integer page, Integer limit);

    /**
     * 删除评论
     * @param coid
     */
    void delComment(String coid);

    /**
     * 发布评论
     * @param commentVo
     */
    void addComment(CommentVo commentVo);

    /**
     * 修改评论
     * @param commentVoExample
     */
    void modifyComment(CommentVoExample commentVoExample);
}
