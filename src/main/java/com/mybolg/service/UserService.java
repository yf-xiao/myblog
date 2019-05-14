package com.mybolg.service;

import com.mybolg.modal.vo.UserVo;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username, String password);

    /**
     * 注销
     * @param username
     */
    void cancelLogin(String username);
}
