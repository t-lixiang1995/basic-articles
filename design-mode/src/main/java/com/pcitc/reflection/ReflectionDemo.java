package com.pcitc.reflection;

import java.lang.reflect.Field;

/**
 * @Author: pcitc
 * @Date: 2019-01-11
 * @Description: 反射
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        User user = new User();
//        user.name
        Field field = user.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String name = (String) field.get(user);
        System.out.println("userName = " + name);
        field.set(user, "中国石化");
        name = (String) field.get(user);
        System.out.println("userName = " + name);
    }
}
