package com.pcitc.demomvc.seniormvcinterceptor.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: pcitc
 * @Description: 老子过滤
 */
public class LzInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String shitFilter = ((String)request.getAttribute("filteredContent")).replace("老子", "lz");
        request.setAttribute("filteredContent", shitFilter);
        System.out.printf("LzInterceptor preHandle方法执行。。。");
        System.out.println();
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.printf("LzInterceptor postHandle 方法执行。。。");
        System.out.println();
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.printf("LzInterceptor afterCompletion 方法执行。。。");
        System.out.println();
    }
}
