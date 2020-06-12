package com.pcitc.concurrent.concurrentinterview.test.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockExecutor {
    public static int NUM = 0;

    public static void main(String[] args) throws InterruptedException{

        doDefalutGroup();
        Thread.sleep(3000);
        System.out.println("最终结果是" + NUM);
    }

    public static void doDefalutGroup(){

        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        ReentrantLock Lock = new ReentrantLock();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 4; j++) {
                    try {
                        Lock.lock();
                        System.out.println(NUM++);
                    }
                    finally {
                        Lock.unlock();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
