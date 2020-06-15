package com.pcitc.idempotent_demo.service.impl;


import com.pcitc.idempotent_demo.Constant.ResponseCode;
import com.pcitc.idempotent_demo.exception.classify.BusinessException;
import com.pcitc.idempotent_demo.service.TokenService;
import com.pcitc.idempotent_demo.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

import com.pcitc.idempotent_demo.Constant.Redis;

/**
 * @author lixiang
 * @date 2020/5/6 9:36
 * @desc
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;


    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString().replaceAll("-","");
        StrBuilder token = new StrBuilder();
        try {
            token.append(Redis.TOKEN_PREFIX).append(str);
            Boolean result = redisService.setEx(token.toString(), token.toString(),10000L);
            boolean notEmpty = StringUtils.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {

        String token = request.getHeader(Redis.TOKEN_NAME);
        System.out.println(token);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(Redis.TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new BusinessException(ResponseCode.ILLEGAL_ARGUMENT, 100);
            }
        }

        if (!redisService.exists(token)) {
            throw new BusinessException(ResponseCode.REPETITIVE_OPERATION, 200);
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new BusinessException(ResponseCode.REPETITIVE_OPERATION, 200);
        }
        return true;
    }
}