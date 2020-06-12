package com.pcitc.interviewdemo.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author pcitc
 * @Description ConcurrentModificationException异常讲解
 */
public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {
//        oneThreadTest();
        multiThreadTest();
    }

    public static void oneThreadTest() {
        //定义一个list
        List<String> list = new ArrayList<>();
        //添加一些元素
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        //得到迭代器
        Iterator<String> iterator = list.iterator();
        //遍历list中的元素
        while (iterator.hasNext()) {
            //集合中的每个元素
            String element = iterator.next();
            if ("李四".equals(element)) {
                //错误示范：删除李四
                list.remove(element);
                //正确示范：删除李四
//                iterator.remove();
            }
        }
    }

    public static void multiThreadTest() {
        //定义一个list
        ArrayList<String> list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        //线程1
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                Iterator<String> iterator = list.iterator();
                while(iterator.hasNext()){
                    String element = iterator.next();
                    System.out.println("我是线程1，得到的元素是" + element);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };

        //线程2
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                Iterator<String> iterator = list.iterator();
                while(iterator.hasNext()){
                    String element = iterator.next();
                    System.out.println(element);
                    if ("李四".equals(element)) {
                        //多线程下错误示范：删除李四
                        iterator.remove();
                    }
                }
            };
        };

        thread1.start();
        thread2.start();
    }
}
