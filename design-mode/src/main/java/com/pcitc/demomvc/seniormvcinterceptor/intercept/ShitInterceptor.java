package com.pcitc.demomvc.seniormvcinterceptor.intercept;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: pcitc
 * @Description: shit过滤
 */
public class ShitInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String shitFilter = ((String)request.getAttribute("filteredContent")).replace("shit", "****");
        request.setAttribute("filteredContent", shitFilter);
        System.out.printf("ShitInterceptor preHandle方法执行。。。");
        System.out.println();
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.printf("ShitInterceptor postHandle方法执行。。。");
        System.out.println();
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
        System.out.printf("ShitInterceptor afterCompletion方法执行。。。");
        System.out.println();
    }
}
