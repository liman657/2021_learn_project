package com.learn.redisson.api.service;/**
 * Created by Administrator on 2020/1/13.
 */

import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:liman
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2020/2/13 10:09
 **/
@NoArgsConstructor
public class RemoteResponse<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public RemoteResponse(RemoteStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public RemoteResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RemoteResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}