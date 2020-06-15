package com.pcitc.demomvc.seniormvcinterceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pcitc
 * @Description: fuck，shit，沙雕产品经理的沙雕需求，老子不干了
 */
@RestController
public class SeniorFilterController {
    /**
     * 过滤方法
     *
     * 留个坑：controller里使用private方法会出现什么状况？？？
     */
    @RequestMapping("/senior/filter")
    private void filter(HttpServletRequest request) {
        System.out.println(request.getAttribute("filteredContent"));
    }
}
