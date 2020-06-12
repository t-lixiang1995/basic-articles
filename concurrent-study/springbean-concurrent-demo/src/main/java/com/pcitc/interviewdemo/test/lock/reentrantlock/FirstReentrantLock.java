package com.pcitc.interviewdemo.test.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author pcitc
 * @Description
 */
public class FirstReentrantLock implements Runnable {
    /**
     * 重入锁
     */
    public static ReentrantLock lock = new ReentrantLock();

    /**
     * 计数器
     */
    public static int count = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "加锁成功！");
            //同一个线程中，再次对lock加锁，验证重进入
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "加锁成功！");
            try {
                count++;
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁成功！");
                //埋坑，如果少解锁一次，会发生什么？？？
                //会发生线程2不能对lock加锁
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁成功！");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FirstReentrantLock test = new FirstReentrantLock();
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test, "线程2");
        t1.start();
        t2.start();
        // main线程会等待t1和t2都运行完再执行以后的流程，join方法详解见面试PPT
        t1.join();
        t2.join();
        System.out.println("总共对lock加锁" + count + "次");
    }
}
