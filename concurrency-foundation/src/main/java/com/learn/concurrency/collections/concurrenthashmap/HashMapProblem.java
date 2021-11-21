package com.learn.concurrency.collections.concurrenthashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:HashMap的简介与问题
 */
@Slf4j
public class HashMapProblem {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.isEmpty());
        map.put("man",20);
        map.put("coder",100);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.get("coder"));
        System.out.println(map.size());
        System.out.println(map.containsKey("man"));
    }

}
