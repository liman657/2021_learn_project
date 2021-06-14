package com.learn.springread.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * autor:liman
 * createtime:2021/6/6
 * comment:
 */
public class UserRegisterEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }
}
