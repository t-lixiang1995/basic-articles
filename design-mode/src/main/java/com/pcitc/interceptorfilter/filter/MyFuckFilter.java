package com.pcitc.interceptorfilter.filter;

import org.springframework.util.StringUtils;

/**
 * @Author: pcitc
 * @Description:
 */
public class MyFuckFilter implements Filter {
    /**
     * 过滤方法
     *
     * @param content
     */
    public String doFilter(String content) {
       if (!StringUtils.isEmpty(content)) {
           return content.replace("fuck", "****");
       }
       return "";
    }

    /**
     * 后置处理方法
     *
     * @param content
     */
    public void doPost(String content) {
        System.out.println("MyFuckFilter执行结束");
    }

    /**
     * 发布时间
     */
    public void doPublish() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyFuckFilter结束时间=" + System.currentTimeMillis());
    }

}
