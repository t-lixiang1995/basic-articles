package com.pcitc.rpc_study.service.impl;

import com.pcitc.rpc_study.service.HelloService;

/**
 * @author lixiang
 * @date 2020/4/17 15:19
 * @desc
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
