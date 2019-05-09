package com.eshop.utils;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆态校验拦截器、用于拦截需要登陆态的请求，如果用户未登陆则重定向到指定页面
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (LoginUtils.checkLogin(request)) {
            return super.preHandle(request, response, handler);
        }
        try {
            // 重定向页面，可以修改
            response.sendRedirect("/shoes/login.html");
        } catch (Exception e) {
            // no operation
        }
        return false;
    }
}
