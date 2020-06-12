package com.pcitc.interviewdemo.spring.containerlifecycle;

import com.pcitc.interviewdemo.test.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author pcitc
 * @Description Bean级生命周期+容器级生命周期测试
 */
public class ContainerDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-chapter2-person.xml",
                "classpath:spring-chapter2-container.xml");
        Person beanLifecycle = context.getBean("beanLifecycle",Person.class);
        beanLifecycle.sayHello();
        context.close();
    }
}
