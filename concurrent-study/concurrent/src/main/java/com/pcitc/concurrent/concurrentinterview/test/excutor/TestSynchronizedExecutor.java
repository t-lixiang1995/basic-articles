package com.pcitc.concurrent.concurrentinterview.test.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * synchronized和volatile的区别：
 *
 *一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
 *1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是
 *    立即可见的。
 *2）禁止进行指令重排序。
 *   volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取；
 *   synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
 *1.volatile仅能使用在变量级别；
 *   synchronized则可以使用在变量、方法、和类级别的
 *2.volatile仅能实现变量的修改可见性，并不能保证原子性；
 *   synchronized则可以保证变量的修改可见性和原子性
 *3.volatile不会造成线程的阻塞；
 *   synchronized可能会造成线程的阻塞。
 *4.volatile标记的变量不会被编译器优化；
 *   synchronized标记的变量可以被编译器优化
 *
 * @author pcitc
 *
 */
public class TestSynchronizedExecutor {
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
                    incr();
                }
            });
        }
        executorService.shutdown();
    }
    public static synchronized void incr(){
        System.out.println(NUM++);
    }
}
