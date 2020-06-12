package com.pcitc.concurrent.concurrentinterview.test.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNumberCounterExecutor {
    public static int NUM = 0;

    public static void main(String[] args) throws InterruptedException{

        doDefalutGroup();
        Thread.sleep(3000);
        System.out.println("最终结果是" + NUM);
    }

    public static void doDefalutGroup(){

        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    System.out.println(NUM++);
                }
            });
        }
        executorService.shutdown();
    }
}
