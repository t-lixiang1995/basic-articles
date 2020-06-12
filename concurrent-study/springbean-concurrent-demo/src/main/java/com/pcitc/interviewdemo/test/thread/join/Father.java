package com.pcitc.interviewdemo.test.thread.join;

/**
 * @Author pcitc
 * @Description 父线程
 */
public class Father extends Thread {

    public Father (String name) {
        super(name);
    }

    @Override
    public void run() {
        //子线程处于 NEW 状态
        Son son = new Son();
        //线程处于 RUNNABLE 状态
        son.start();
        try {
            //等待Son线程执行结束
            // 不携带参数的join()会调用join(0)，表示无限等待，直到Son结束
            son.join();
            //携带参数的join()表示Father等待Son的时间
//            son.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //因为子线程是耗时的，父线程会不会立刻执行到下面这个代码这里？
        //如果调用的是Son携带参数的join()又会怎样？
        System.out.println("我是父类father");
    }
}
