package com.pcitc.interviewdemo.test.thread.join;

/**
 * @Author pcitc
 * @Description 测试join
 */
public class JoinTest {
    public static void main(String[] args) {
        Father father = new Father("Father Thread");
        father.start();
    }
}
