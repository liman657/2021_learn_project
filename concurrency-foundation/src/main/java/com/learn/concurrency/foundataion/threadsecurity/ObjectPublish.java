package com.learn.concurrency.foundataion.threadsecurity;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/9/26
 * comment:对象发布和逸出时的线程安全问题
 * 发布逸出，方法返回一个private对象
 */
@Slf4j
public class ObjectPublish {

    private Map<String,String> states;

    public ObjectPublish() {
        this.states = new HashMap<>();
        states.put("1","周一");
        states.put("2","周二");
        states.put("3","周三");
        states.put("4","周四");
        states.put("5","周五");
        states.put("6","周六");
    }

    //states逸出了，因为这里将private的对象返回给外部接口，外部接口可以对其中的数据进行操作
    public Map<String,String> getStates(){
        return states;
    }

    public static void main(String[] args) {
        ObjectPublish objectPublish = new ObjectPublish();
        Map<String, String> states = objectPublish.getStates();
        System.out.println(states.get("1"));
        states.remove("1");
        System.out.println(states.get("1"));
    }
}