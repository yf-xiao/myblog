package com.mybolg.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybolg.dao.UserVoMapper;
import com.mybolg.exception.TipException;
import com.mybolg.modal.vo.UserVo;
import com.mybolg.modal.vo.UserVoExample;
import com.mybolg.service.UserService;
import com.mybolg.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserVoMapper userDao;

    @Override
    public UserVo login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码为空");
        }

        UserVoExample example = new UserVoExample();
        UserVoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        long count = userDao.countByExample(example);

        if (count < 1) {
            throw new TipException("不存在该用户");
        }

        String pwd = MD5Util.MD5EncodeUtf8(username + password);
        criteria.andPasswordEqualTo(pwd);
        List<UserVo> userVoList = userDao.selectByExample(example);

        if (userVoList.size() != 1) {
            throw new TipException("用户名或者密码错误");
        }

        return userVoList.get(0);
    }

    @Override
    public void cancelLogin(String username) {
        // TODO Auto-generated method stub
        
    }

}
