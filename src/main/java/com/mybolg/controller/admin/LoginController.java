package com.mybolg.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybolg.constant.WebConst;
import com.mybolg.dao.UserVoMapper;
import com.mybolg.exception.TipException;
import com.mybolg.modal.bo.RestResponseBo;
import com.mybolg.modal.vo.UserVo;
import com.mybolg.service.UserService;
import com.mybolg.util.MapCache;

@Controller
@RequestMapping("/admin/login")
public class LoginController {

    @Autowired
    UserService userService;

    protected MapCache cache = MapCache.getSingle();

    @GetMapping(value = "")
    public String login() {
        return "admin/login";
    }

    @PostMapping(value = "")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,@RequestParam String password,
            HttpServletRequest request, HttpServletResponse response) {
        Integer login_error_count = cache.get("login_error_count");

        try {
            login_error_count = null == login_error_count ? 1 : login_error_count + 1;

            if (login_error_count > 3) {
                throw new TipException("账号或密码输出错误次数超过三次，请十分钟之后重试");
            }

            UserVo userVo = userService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, userVo);
        } catch (Exception e) {
//            cache.set("login_error_count", login_error_count, 10 * 60);
            cache.set("login_error_count", login_error_count, 3);
            return RestResponseBo.fail(e.getMessage());
        }
        return RestResponseBo.ok();
    }
}
