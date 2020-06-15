package com.pcitc.interceptorfilter;

/**
 * @Author: pcitc
 * @Description: 客户端
 */
public class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}