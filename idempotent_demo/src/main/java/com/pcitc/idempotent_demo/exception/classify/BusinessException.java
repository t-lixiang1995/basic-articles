package com.pcitc.idempotent_demo.exception.classify;

import com.pcitc.idempotent_demo.exception.model.EnumResult;

/**
 * @author lixiang
 * @date 2020/5/6 11:01
 * @desc 自定义业务逻辑异常
 */
public class BusinessException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BusinessException() {}

    public BusinessException(EnumResult resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(Throwable e){
        super(e);
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
