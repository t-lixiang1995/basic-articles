package com.pcitc.proxy;

/**
 * 静态代理
 * 明星-经纪人
 *
 * @author : pcitc
 * @since : 2019年04月17日 20:33
 */


//代理类
public class ProxyDemo implements Teacher {

    //被代理对象
    private Teacher teacher;

    public ProxyDemo(Teacher teacher) {
        this.teacher = teacher;
    }

    public void before(){
        System.out.println("上课前预习");
    }

    public void after(){
        System.out.println("上课后 复习... ");
    }

    public void teach() {

        this.before();
        teacher.teach();
        this.after();
    }
}

class  Client{
    public static void main(String[] args) {
        Teacher teacher = new ProxyDemo(new Five());
        // 课堂教学
        teacher.teach();
    }
}

interface Teacher{
    public void teach();
}
//被代理类
class Five implements  Teacher{
    public void teach() {
        System.out.println("在教授高数课");
    }
}


