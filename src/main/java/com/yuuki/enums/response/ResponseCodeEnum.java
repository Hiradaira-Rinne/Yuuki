package com.yuuki.enums.response;

/**
 * @author Yuuki
 * @date 2022/6/22 17:44
 */
public enum ResponseCodeEnum {

    /**
     * ok
     */
    Y00000("OK", "操作成功"),

    /**
     * 500
     */
    E00005("EXCEPTION", "服务器出了点小差");



    private final String code;

    private final String msg;

    public String value() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResponseCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseEnum{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + "} " + super.toString();
    }

}
