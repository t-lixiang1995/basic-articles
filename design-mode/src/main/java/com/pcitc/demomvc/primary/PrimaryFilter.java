package com.pcitc.demomvc.primary;

/**
 * @Author: pcitc
 * @Description: 特殊字符处理/加解密/美团id点评id互转
 */
public class PrimaryFilter {
    public static String content = "fuck，shit，沙雕产品经理的沙雕需求，老子不干了";
    public static void main(String[] args) {
        String filteredContent = content.replace("fuck", "****")
                .replace("shit", "****")
                .replace("沙雕", "sd")
                .replace("老子","lz");
        System.out.println(filteredContent);
    }
}
