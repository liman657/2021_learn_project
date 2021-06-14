package com.learn.springread.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/6/6
 * comment:
 */
@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String username){
        System.out.println(username+"用户注册");
        //发送事件
        applicationEventPublisher.publishEvent(new UserRegisterEvent(username));
    }

}
