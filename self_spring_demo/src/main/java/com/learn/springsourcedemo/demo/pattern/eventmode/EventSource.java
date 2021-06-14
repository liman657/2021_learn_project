package com.learn.springsourcedemo.demo.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment: 事件源
 */
public class EventSource {

    private List<EventListener> eventListenerList = new ArrayList<>();

    /**
     * 注册事件
     * @param eventListener
     */
    public void register(EventListener eventListener){
        eventListenerList.add(eventListener);
    }

    /**
     * 发布（触发）事件
     * @param event
     */
    public void publish(Event event){
        for(EventListener eventListener:eventListenerList){
            eventListener.processEvent(event);
        }
    }
}
