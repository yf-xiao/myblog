package com.mybolg.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mybolg.constant.WebConst;
import com.mybolg.modal.vo.UserVo;


public class SessionUtil {
    public static UserVo getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) {
            return null;
        }
        return (UserVo) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }
}
