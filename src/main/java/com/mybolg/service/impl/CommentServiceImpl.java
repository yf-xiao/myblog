package com.mybolg.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybolg.dao.CommentVoMapper;
import com.mybolg.modal.vo.CommentVo;
import com.mybolg.modal.vo.CommentVoExample;
import com.mybolg.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentVoMapper commentVoMapper;

    @Override
    public PageInfo<CommentVo> getComments(CommentVo commentVo, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        CommentVoExample commentVoExample = new CommentVoExample();
        commentVoExample.createCriteria().andCidEqualTo(commentVo.getCid());
        commentVoExample.createCriteria().andCoidEqualTo(commentVo.getCoid());
        commentVoExample.createCriteria().andAuthorEqualTo(commentVo.getAuthor());
        commentVoExample.createCriteria().andAuthorEqualTo(commentVo.getAuthor());
        commentVoExample.createCriteria().andMailEqualTo(commentVo.getMail());
        commentVoExample.createCriteria().andStatusEqualTo(StringUtils.isNotBlank(commentVo.getStatus()) ? commentVo.getStatus() : "approved");
        List<CommentVo> comments = commentVoMapper.selectByExample(commentVoExample);
        return new PageInfo<>(comments);
    }

    @Override
    public void delComment(String coid) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addComment(CommentVo commentVo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void modifyComment(CommentVoExample commentVoExample) {
        // TODO Auto-generated method stub

    }

}
