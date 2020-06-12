package com.pcitc.interviewdemo.spring.factorylifecycle;

import com.pcitc.interviewdemo.test.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author pcitc
 * @Description Bean级生命周期+容器级生命周期测试+工厂级生命周期
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring-chapter2-person.xml",
                "classpath:spring-chapter2-container.xml", "spring-chapter2-factory.xml");
        Person beanLifecycle = context.getBean("beanLifecycle",Person.class);
        beanLifecycle.sayHello();
        context.close();
    }
}
