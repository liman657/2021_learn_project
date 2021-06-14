package com.learn.springsourcedemo.demo.pattern.eventmode;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment: 双击的事件监听器
 */
public class DoubleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if("doubleclick".equalsIgnoreCase(event.getType())){
            System.out.println("双击事件被触发");
        }
    }
}
