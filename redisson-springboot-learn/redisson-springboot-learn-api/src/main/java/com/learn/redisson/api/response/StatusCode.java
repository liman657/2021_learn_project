package com.learn.redisson.api.response;

/**
 * 接口的响应状态码
 * Created by Administrator on 2020/2/6.
 */
public enum StatusCode {

    Success(200,"成功"),
    Fail(-1,"失败"),

    InvalidParams(10010,"非法的参数！"),
    MailInfoSendDateTimeInvalidated(20000,"指定邮件为延迟发送时，其发送时间必填！"),
    ProductKillFail(30000,"商品抢购失败，请刷新浏览器再重试！"),


    ;


    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
