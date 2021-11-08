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
 * comment:用ThreadLocal解决SimpleDateFormat的线程安全问题
 */
@Slf4j
public class SimpleDateFormatThreadLocal {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    //共享SimpleDateFormat
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //记录重复数据
    private static Set<String> resultSet = new HashSet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            threadPool.submit(new Thread(() -> {
                String date = new SimpleDateFormatThreadLocal().dateFormat(finalI);
                System.out.println(date);
            }));
        }
        threadPool.shutdown();
    }

    public String dateFormat(int seconds) {
        //从1970-01-01 00:00:00开始计算
        Date date = new Date(1000 * seconds);
        String result = ThreadSafeSimpleDateFormat.dateFormatThreadLocal.get().format(date);
        if(resultSet.contains(result)){
            log.warn("{}，出现重复数据",result);
        }
        resultSet.add(result);
        return result;
    }
}

//用一个内部类构造ThreadLocal
class ThreadSafeSimpleDateFormat{
//    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        }
//    };

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal
            = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
}
