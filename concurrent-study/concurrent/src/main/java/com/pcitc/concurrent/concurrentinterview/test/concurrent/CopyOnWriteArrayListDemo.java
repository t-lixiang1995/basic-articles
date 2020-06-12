package com.pcitc.concurrent.concurrentinterview.test.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * pcitc
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        testMultiThread();
    }

    public static void testMultiThread() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");

        //线程1
        Thread thread1 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                if ("李四".equals(element)) {
                    list.remove(element);
                    System.out.println("线程1删除李四");
                } else {
                    System.out.println("线程1遍历的元素：" + element);
                }
            }
        });

        //线程2
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                System.out.println("线程2遍历的元素：" + element);
            }
        });

        thread1.start();
        thread2.start();
    }
}
