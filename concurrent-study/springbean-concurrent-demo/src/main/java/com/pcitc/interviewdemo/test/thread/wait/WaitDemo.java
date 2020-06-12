package com.pcitc.interviewdemo.test.thread.wait;

/**
 * @Author pcitc
 * @Description wait方法测试
 */
public class WaitDemo {

    public static void main(String[] args) throws InterruptedException {
        RunnableA runnableA = new RunnableA();
        Thread threadA = new Thread(runnableA);

        RunnableB runnableB = new RunnableB();
        Thread threadB = new Thread(runnableB);

        threadA.start();
        Thread.sleep(1000);
        threadB.start();
    }

    private static class RunnableA implements Runnable {

        @Override
        public void run() {
            synchronized (WaitDemo.class) {
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的
                    // 等待锁定池，也就是JVM源码中的WaitSet
                    WaitDemo.class.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程A");
            }
        }
    }

    private static class RunnableB implements Runnable {

        @Override
        public void run() {
            synchronized (WaitDemo.class) {
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态
                //如果不调用notify()方法会发生什么？
                //不调用notify()将会导致线程A无法运行，因为线程A会在WaitSet中继续等待
                WaitDemo.class.notify();
                System.out.println("我是线程B");
            }
        }
    }
}
