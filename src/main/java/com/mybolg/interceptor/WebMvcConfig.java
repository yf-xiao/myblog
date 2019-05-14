package com.mybolg.interceptor;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {
    //  注入拦截器
    @Resource
    private BaseInterceptor baseInterceptor;

    //   把自定义的拦截器添加到mvc 配置中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor).addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("/admin/css/**", "/user/**"));
    }
}
