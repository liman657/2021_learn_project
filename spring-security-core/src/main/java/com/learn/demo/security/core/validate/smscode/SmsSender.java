package com.learn.demo.security.core.validate.smscode;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment: 发送短信的接口
 */
public interface SmsSender {

    public void sendCode(String mobile,String code);

}
