package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021/11/8
 * comment:加锁解决SimpleDateFormat的线程安全问题
 */
@Slf4j
public class SimpleDateFormatLockSlove {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    //共享SimpleDateFormat
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //记录重复数据
    private static Set<String> resultSet = new HashSet<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPool.submit(new Thread(() -> {
                String date = new SimpleDateFormatLockSlove().dateFormat(finalI);
                System.out.println(date);
            }));
        }
        threadPool.shutdown();
        Thread.sleep(10000);
        if(threadPool.isTerminated()) {
            log.info("最终的set中个数为:{}", resultSet.size());
        }
        System.out.println(threadPool.isTerminated());
    }

    public String dateFormat(int seconds) {
        //从1970-01-01 00:00:00开始计算
        Date date = new Date(1000 * seconds);
        String result = "";
        synchronized (SimpleDateFormatLockSlove.class) {
            result = dateFormat.format(date);
            resultSet.add(result);
        }
        return result;
    }
}
