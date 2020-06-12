package com.pcitc.interviewdemo.spring.beanlifcycle;

import com.pcitc.interviewdemo.test.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author pcitc
 * @Description Bean生命周期测试(bean级)
 */
public class PersonDemo {

    public static void main(String[] args) {
        //只启动BeanLifecycle这一个Bean，观察效果
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-chapter2-person.xml");
        Person beanLifecycle = context.getBean("beanLifecycle", Person.class);
        beanLifecycle.sayHello();
        context.close();
    }

}
