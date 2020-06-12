package com.pcitc.interviewdemo.test.spring.container;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @Author pcitc
 * @Description 容器级生命周期
 */
public class Container extends InstantiationAwareBeanPostProcessorAdapter {
    /**
     * 构造器
     */
    public Container() {
        System.out.println("A  Container()");
    }

    /**
     * 实例化Bean之前执行
     */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) {
        System.out.println("B  postProcessBeforeInstantiation(Class beanClass, String beanName)");
        return null;
    }

    /**
     * 设置Bean某个属性时执行
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) {
        System.out.println("C  postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)");
        return pvs;
    }

    /**
     * 实例化Bean之后执行
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("D  postProcessAfterInitialization");
        return null;
    }
}
