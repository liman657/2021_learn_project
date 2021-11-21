package com.learn.concurrency.collections.old;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment: 说明HashTable的不足，HashTable就是线程安全的HashMap
 */
@Slf4j
public class HashTableDemo {

    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("name","tom");
        String name = hashtable.get("name");
        System.out.println(name);
    }

}
