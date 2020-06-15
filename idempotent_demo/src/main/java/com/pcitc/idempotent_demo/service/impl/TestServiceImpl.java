package com.pcitc.idempotent_demo.service.impl;

import com.pcitc.idempotent_demo.service.TestService;
import com.pcitc.idempotent_demo.service.TokenService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lixiang
 * @date 2020/5/6 14:27
 * @desc
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String testIdempotence() {
        return "验证接口幂等性成功!";
    }
}
