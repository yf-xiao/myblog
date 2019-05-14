package com.mybolg.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mybolg.modal.bo.RestResponseBo;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public RestResponseBo resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception e) {
        log.error("{} Exception", e);
        return RestResponseBo.fail("接口异常,详情请查看服务端日志的异常信息");
    }
}
