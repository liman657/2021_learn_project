package com.learn.springsourcedemo.demo.pattern.eventmode;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment:
 */
public class EventModeDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
        DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();
        Event event = new Event();
        event.setType("doubleclick");
        //注册事件
        eventSource.register(singleClickEventListener);
        eventSource.register(doubleClickEventListener);

        eventSource.publish(event);
    }
}
