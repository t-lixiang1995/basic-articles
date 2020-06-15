package com.pcitc.idempotent_demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.idempotent_demo.annotation.AutoIdempotent;
import com.pcitc.idempotent_demo.result.RetCodeMsg;
import com.pcitc.idempotent_demo.result.RetResult;
import com.pcitc.idempotent_demo.result.RetResultUtil;
import com.pcitc.idempotent_demo.service.TestService;
import com.pcitc.idempotent_demo.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lixiang
 * @date 2020/5/6 10:25
 * @desc
 */
@RestController
public class BusinessController {


    @Resource
    private TokenService tokenService;

    @Resource
    private TestService testService;


    @GetMapping("/get/token")
    public String  getToken(){
        String token = tokenService.createToken();
        if (StringUtils.isNotEmpty(token)) {
            RetResult resultVo = new RetResult();
            resultVo.setCode(RetCodeMsg.SUCCESS);
            resultVo.setMsg(RetCodeMsg.SUCCESS);
            resultVo.setData(token);
            return JSON.toJSONString(resultVo);
        }
        return StringUtils.EMPTY;
    }


    @AutoIdempotent
    @PostMapping("/test/Idempotence")
    public String testIdempotence() {
        String businessResult = testService.testIdempotence();
        if (StringUtils.isNotEmpty(businessResult)) {
            RetResult successResult = RetResultUtil.ok(businessResult);
            return JSON.toJSONString(successResult);
        }
        return StringUtils.EMPTY;
    }
}
