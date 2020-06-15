package com.pcitc.interceptorfilter;

import com.pcitc.interceptorfilter.filter.Filter;

/**
 * @Author: pcitc
 * @Description: 过滤器管理员
 */
public class FilterManager {
    private FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }
}
