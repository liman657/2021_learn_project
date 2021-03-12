package com.learn.redisson.api.service;/**
 * Created by Administrator on 2020/1/13.
 */

import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2020/2/13 10:10
 **/
public enum  RemoteStatus implements Serializable{

    Success(200,"成功"),
    Fail(-1,"失败"),

    ;

    private Integer code;
    private String msg;

    RemoteStatus(Integer code, String msg) {
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