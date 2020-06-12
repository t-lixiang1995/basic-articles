package com.pcitc.interviewdemo.test.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author pcitc
 * @Description 可中断锁
 */
public class DeadlockDemo implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int count;

    public DeadlockDemo(int lock) {
        this.count = lock;
    }

    @Override
    public void run() {
        try {
            if (count == 1) {
                // 以可以响应中断的方式加锁
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } else {
                // 以可以响应中断的方式加锁
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "执行结束");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "异常，异常原因:" + e);
        } finally {
            // 注意判断方式
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }

            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "退出！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadlockDemo deadLock1 = new DeadlockDemo(1);
        DeadlockDemo deadLock2 = new DeadlockDemo(2);
        Thread thread1 = new Thread(deadLock1, "测试线程1");
        Thread thread2 = new Thread(deadLock2, "测试线程2");
        //线程1和线程2都会对lock1和lock2进行加锁，发生死锁
        thread1.start();
        thread2.start();
        //观察线程执行结果，此处死锁，所以不会有输出，10s后开启中断，避免死锁继续下去
        Thread.sleep(10000);
        //中断线程2，导致线程2直接异常退出，线程1因为获取到lock2锁而继续执行后退出
        thread2.interrupt();
    }
}
