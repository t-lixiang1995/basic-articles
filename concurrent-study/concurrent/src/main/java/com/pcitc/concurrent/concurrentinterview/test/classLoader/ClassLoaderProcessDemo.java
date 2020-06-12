package com.pcitc.concurrent.concurrentinterview.test.classLoader;

/**
 * 类加载过程实例
 * pcitc
 */
public class ClassLoaderProcessDemo {
    public static void main(String[] args){
        Zi zi = new Zi();
        zi.show();
    }
}
class Fu{
    int num1 = 10;
    int num2 = 5;
    public Fu(){
        super();
        show();
    }
    public void show(){
        System.out.println("Fu show" + num1 + "\t" + num2);
    }
}

class Zi extends Fu{
    int num2 = 20;
    public Zi(){
        show();
    }
    public void show(){
        System.out.println("Fu show" + num1 + "\t" + num2);
    }
}