package com.pcitc.interceptorfilter.filter;

/**
 * @Author: pcitc
 * @Description: 过滤器接口
 */
public interface Filter {
    /**
     * 过滤方法
     */
    String doFilter(String content);

    /**
     * 后置处理方法
     */
    void doPost(String content);

    /**
     * 发布时间
     */
    void doPublish();
}
