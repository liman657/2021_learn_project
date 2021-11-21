package com.learn.concurrency.collections.concurrenthashmap;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * autor:liman
 * createtime:2021/11/21
 * comment:简单的ConcurrentHashMap使用实例
 */
@Slf4j
public class ConcurrentHashMapOptionsNotSafeDemo implements Runnable{

    private static ConcurrentHashMap<String ,Integer> scores = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        scores.put("codeman",100);
        Thread threadOne = new Thread(new ConcurrentHashMapOptionsNotSafeDemo());
        Thread threadTwo = new Thread(new ConcurrentHashMapOptionsNotSafeDemo());
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println(scores.get("codeman"));
    }


    @Override
    public void run() {
//        for(int i=0;i<1000;i++){
//            Integer score = scores.get("codeman");
//            int newScore = score+1;
//            scores.put("codeman",newScore);
//        }
        for(int i=0;i<1000;i++){
            while(true) {
                Integer score = scores.get("codeman");
                int newScore = score + 1;
                boolean putsuccess = scores.replace("codeman", score, newScore);
                if(putsuccess){
                    break;
                }
            }
        }
    }
}
