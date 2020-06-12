package com.pcitc.concurrent.concurrentinterview.test.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 可以看出，程序运行的结果是不确定的，这说明了NUM++并不是原子级别的操作。原因是声明为volatile的变量若与自身相关，如以下的声明方式：NUM=NUM+1,NUM++等，
 * 那么声明为volatile的变量就不起作用，也就是说关键字volatile无效.
 * -----------------------------
 * 在 java 的内存模型中每一个线程运行时都有一个线程栈，线程栈保存了线程运行时候变量值信息。当线程访问
 *某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存变量的具体值load到线
 *程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
 *在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象
 *的值就产生变化了。
 *---------------------------------
 *也就是说上面主函数中开启了1000 个子线程，每个线程都有一个变量副本，每个线程修改变量只是临时修改了
 *自己的副本，当线程结束时再将修改的值写入在主内存中，这样就出现了线程安全问题。因此结果就不可能等于1000
 *了，一般都会小于1000。
 *若想将count的操作变为原子级别，可以使用关键字synchronized，或者加锁，或者使用AtomicInteger原子类
 *
 * @author pcitc
 *
 */
public class TestVolatileExecutor {
    private static volatile int NUM = 0;

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
