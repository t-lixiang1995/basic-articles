package com.pcitc.idempotent_demo.service;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    /**
     * 创建token
     * @return
     */
    public  String createToken();

    /**
     * 检验token
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) throws Exception;

}
