package com.learn.demo.security.core.validate.smscode;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
public class DefaultSmsSender implements SmsSender {
    @Override
    public void sendCode(String mobile, String code) {
        System.out.println("这里是模拟短信发送，手机号："+mobile+" 发送内容： "+code);
    }
}
