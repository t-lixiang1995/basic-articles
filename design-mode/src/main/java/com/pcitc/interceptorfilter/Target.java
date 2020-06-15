package com.pcitc.interceptorfilter;

/**
 * @Author: pcitc
 * @Description:
 */
public class Target {
    public void execute(String request){
        System.out.println("request=" + request);
    }
}
