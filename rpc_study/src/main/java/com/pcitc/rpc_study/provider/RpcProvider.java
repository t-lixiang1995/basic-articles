package com.pcitc.rpc_study.provider;

import com.pcitc.rpc_study.rpc.RpcFramework;
import com.pcitc.rpc_study.service.HelloService;
import com.pcitc.rpc_study.service.impl.HelloServiceImpl;

/**
 * @author lixiang
 * @date 2020/4/17 15:21
 * @desc
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
