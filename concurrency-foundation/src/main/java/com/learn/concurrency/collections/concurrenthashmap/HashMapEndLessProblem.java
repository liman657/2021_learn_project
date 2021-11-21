package com.learn.concurrency.collections.concurrenthashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:hashmap在多线程情况下造成死循环的情况
 */
@Slf4j
public class HashMapEndLessProblem {

    //第一个参数是初始值，第二个参数是负载因子，负载因子决定什么时候扩容
    //当元素个数>2*1.5=3 的时候，容器需要扩容
    private static Map<Integer,String> map = new HashMap<>(2,1.5f);

    public static void main(String[] args) {
        map.put(5,"A");
        map.put(7,"B");
        map.put(3,"C");
        new Thread(()->{
            map.put(15,"D");
            System.out.println(map);
        },"Thread-1").start();
        new Thread(()->{
            map.put(1,"E");
            System.out.println(map);
        },"Thread-2").start();
    }
}