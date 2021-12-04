package com.learn.concurrency.selfcacledemo;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:
 */
public class SimpleCache_01 {

    private final HashMap<String,Integer> cache = new HashMap<>();

    public Integer computer(String userId) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //先检查HashMap里面有没有保存过之前的计算结果
        Integer result = cache.get(userId);
        if(null == result){
            //如果缓存中找不到，那么需要现在计算一下结果，并且保存到HashMap中
            result = doComputer(userId);
            cache.put(userId,result);
        }
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("计算耗时:"+costTime);
        return result;
    }

    private Integer doComputer(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new Integer(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCache_01 simpleCache01 = new SimpleCache_01();
        Integer result = simpleCache01.computer("1");
        System.out.println("第一次计算结果"+result);
        Integer result02 = simpleCache01.computer("1");
        System.out.println("第二次计算结果"+result02);
    }
}
