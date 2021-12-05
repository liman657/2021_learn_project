package com.learn.concurrency.selfcacledemo;

import com.learn.concurrency.selfcacledemo.computable.Computable;
import com.learn.concurrency.selfcacledemo.computable.ExpensiveFunction;
import com.learn.concurrency.selfcacledemo.computable.SelfFailFunction;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

/**
 * autor:liman
 * createtime:2021/12/4
 * comment:在09的基础上，利用线程池进行测试
 */
@Slf4j
public class TestCacheDemo_10 {

    private static ExpireCacheDemo_09 expireCache = new ExpireCacheDemo_09(new ExpensiveFunction());

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Integer threadCount = 10000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                Integer result = null;
                String currentThreadName = Thread.currentThread().getName();
                try {
                    System.out.println(currentThreadName+"开始等待");
                    countDownLatch.await();
                    SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatter.get();
                    String time = dateFormat.format(new Date());
                    System.out.println(currentThreadName+" "+time+"开始计算");
                    result = (Integer) expireCache.compute("666");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(currentThreadName+"得到的结果"+result);
            });
        }
//        executorService.shutdown();
//        while(!executorService.isTerminated()){
//
//        }
        Thread.sleep(5000);
        countDownLatch.countDown();
        executorService.shutdown();
    }

}
class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {

        //每个线程会调用本方法一次，用于初始化
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("hh:mm:ss");
        }

        //首次调用本方法时，会调用initialValue()；后面的调用会返回第一次创建的值
        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}