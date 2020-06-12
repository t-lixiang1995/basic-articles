package com.pcitc.concurrent.concurrentinterview.test.single;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * pcitc
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        //测试单线程情况下集合的操作
//        testSingleThread();

        //测试多线程情况下集合的操作
        testMultiThread();
    }

    /**
     * 测试单线程环境下ArrayList操作
     *
     * 1. 这个程序输出的结果是什么？
     * 2. 为什么是："李四".equals(element) 而不是 element.equals("李四")？
     * 3. 有没有优化方案？
     */
    public static void testSingleThread() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //迭代每个元素
            String element = iterator.next();
            //删除李四这个元素
            if ("李四".equals(element)) {
//                list.remove(element);
                iterator.remove();
            }
        }
        System.out.println(list.size());
     }






    /**
     * 测试多线程环境下ArrayList操作
     * 1.多线程下使用迭代器，是否线程安全
     * 2.有没有优化方案？
     */
    public static void testMultiThread() {
        List<String> list = new ArrayList<>();
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
