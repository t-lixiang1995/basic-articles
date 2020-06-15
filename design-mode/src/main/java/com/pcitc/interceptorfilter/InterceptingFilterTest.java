package com.pcitc.interceptorfilter;

import com.pcitc.interceptorfilter.filter.MyFuckFilter;
import com.pcitc.interceptorfilter.filter.MyLzFilter;
import com.pcitc.interceptorfilter.filter.MyShadiaoFilter;
import com.pcitc.interceptorfilter.filter.MyShitFilter;

/**
 * @Author: pcitc
 * @Description: 测试类
 */
public class InterceptingFilterTest {
    public static void main(String[] args) {

        FilterManager filterManager = new FilterManager(new Target());
        //装配各种过滤器
        filterManager.setFilter(new MyFuckFilter());
        filterManager.setFilter(new MyShitFilter());
        filterManager.setFilter(new MyShadiaoFilter());
        filterManager.setFilter(new MyLzFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("fuck，shit，沙雕产品经理的沙雕需求，老子不干了");
    }
}