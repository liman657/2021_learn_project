package com.learn.springsourcedemo.demo.pattern.eventmode;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment: 单击的事件监听器
 */
public class SingleClickEventListener implements EventListener {
    @Override
    public void processEvent(Event event) {
        if("singleclick".equalsIgnoreCase(event.getType())){
            System.out.println("单击事件被触发");
        }
    }
}
