package com.learn.springsourcedemo.demo.pattern.eventmode;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment: 事件监听器
 */
public interface EventListener {

    public void processEvent(Event event);

}
