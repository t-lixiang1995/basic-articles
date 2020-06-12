package com.pcitc.interviewdemo.test.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author pcitc
 * @Description try锁
 */
public class TryLockDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            // 尝试获取锁，等待1秒
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                //休眠2秒
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } else {
                System.out.println(Thread.currentThread().getName() + "获取锁失败！");
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "异常，原因：" + e);
        } finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        TryLockDemo test = new TryLockDemo();
        Thread thread1 = new Thread(test, "线程1");
        Thread thread2 = new Thread(test, "线程2");
        thread1.start();
        thread2.start();
    }
}
