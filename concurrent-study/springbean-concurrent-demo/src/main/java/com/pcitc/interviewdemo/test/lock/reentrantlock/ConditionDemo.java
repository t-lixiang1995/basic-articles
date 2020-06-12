package com.pcitc.interviewdemo.test.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author pcitc
 * @Description 与关键字synchronized配合使用的方法如：await()、notify()、notifyAll()
 * 与配合ReentrantLock配合使用的Condition
 */
public class ConditionDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.newCondition();
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "-线程开始等待...");
            //释放锁
            condition.await();
            System.out.println(Thread.currentThread().getName() + "-线程继续进行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo test = new ConditionDemo();
        Thread t = new Thread(test, "测试线程");
        t.start();
        Thread.sleep(1000);
        System.out.println("过了1秒后...");
        //主线程加锁
        lock.lock();
        // 调用该方法前需要获取到创建该对象的锁否则会产生
        // java.lang.IllegalMonitorStateException异常
        //唤醒线程
        condition.signal();
        // 主线程释放lock上的锁
        // 如果主线程不释放锁，测试现场将不能获取lock锁
        lock.unlock();
    }
}
