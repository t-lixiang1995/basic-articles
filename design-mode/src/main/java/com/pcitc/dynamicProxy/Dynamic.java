package com.pcitc.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理(代理对象必须实现接口)
 *
 * @author : pcitc
 * @since : 2019年04月17日 20:45
 */
//代理者
public class Dynamic implements InvocationHandler{

    private Object teacher;

    public Dynamic(Object teacher) {
        this.teacher = teacher;
    }

    public void before(){
        System.out.println("上课前预习");
    }

    public void after(){
        System.out.println("上课后 复习... ");
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //具体的业务调用 执行
        this.before();
        Object result = method.invoke(teacher, args); //具体业务
        this.after();
        return result;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(teacher.getClass().getClassLoader(),teacher.getClass().getInterfaces(),this);
    }

}

class Client{
    public static void main(String[] args) {
        Dynamic dnm1 = new Dynamic(new Five());
        JavaTeacher javaTeacher = (JavaTeacher) dnm1.getProxyInstance();
        javaTeacher.teachJava();

        ProxyUtils.getClassFile(javaTeacher.getClass().getSimpleName(),JavaTeacher.class);

        Dynamic dnm2 = new Dynamic(new Six());
        BigDataTeacher bigdataTeacher = (BigDataTeacher) dnm2.getProxyInstance();
        bigdataTeacher.teachBigData();

        ProxyUtils.getClassFile(bigdataTeacher.getClass().getSimpleName(),BigDataTeacher.class);
    }
}

interface JavaTeacher{
    public void teachJava();
}
interface BigDataTeacher{
    public void teachBigData();
}
//被代理类
class Five implements JavaTeacher {
    public void teachJava() {
        System.out.println("在学院教授高数课");
    }
}

//被代理类
class Six implements BigDataTeacher {
    public void teachBigData() {
        System.out.println("在学院教授物理课");
    }
}


