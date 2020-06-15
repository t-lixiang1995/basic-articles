package com.pcitc.idempotent_demo.result;

/**
 * @author lixiang
 * @date 2020/5/6 11:08
 * @desc 复制EnumResult的状态类型
 */
public enum RetCodeMsg {
    UNKONW_ERROR(-1,"未知错误"),

    SUCCESS(0,"成功"),

    ERROR(1,"失败"),

    UNKONW_PK_ERROR(2,"主键数据遗失"),

    UNKONW_BACK_PK_ERROR(3,"返回主键数据异常"),

    UNKONW_REQUEST_OBJ_ERROR(4,"请求对象错误"),

    LINKEDID_ERROR(5,"应用关联编码异常"),

    DELETE_STATUS_ERROR(6,"当前状态不可删除"),

    HAS_CHILD_CHECK_STATUS_ERROR(7, "含有子节点待审数据!"),

    FILE_IS_ERROR(90000, "文件异常"),

    DPS_IS_ERROR(90001, "工作流异常"),

    RDS_IS_ERROR(90000, "数据库异常");

    private int code;
    private String msg;

    RetCodeMsg(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

