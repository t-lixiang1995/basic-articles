package com.pcitc.rpc_study.consumer;

import com.pcitc.rpc_study.rpc.RpcFramework;
import com.pcitc.rpc_study.service.HelloService;

/**
 * @author lixiang
 * @date 2020/4/17 15:21
 * @desc
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
