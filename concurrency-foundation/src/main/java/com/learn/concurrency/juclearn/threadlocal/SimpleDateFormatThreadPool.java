package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021/11/8
 * comment:线程池运行SimpleDateFormat的内容
 */
@Slf4j
public class SimpleDateFormatThreadPool {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            //每个线程都会创建SimpleDateFormat,相当于创建了1000个SimpleDateFormat对象
            threadPool.submit(new Thread(() -> {
                String date = new SimpleDateFormatMultiThread().dateFormat(finalI);
                System.out.println(date);
            }));
        }
        threadPool.shutdown();
    }


}
