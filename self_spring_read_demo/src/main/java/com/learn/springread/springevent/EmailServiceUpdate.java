package com.learn.springread.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/6/6
 * comment:
 */
@Service("emailServiceUpdate")
public class EmailServiceUpdate {
    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("给注册的用户发送邮件：" + event.getSource());
    }
}
