package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * autor:liman
 * createtime:2021/11/7
 * comment:简单的多线程下的SimpleDateFormat实例
 * 两个线程打印，并没有出现问题
 */
@Slf4j
public class SimpleDateFormatDemo {

    public static void main(String[] args) {
        new Thread(()->{
            String date = new SimpleDateFormatDemo().dateFormat(10);
            System.out.println(date);
        }).start();
        new Thread(()->{
            String date = new SimpleDateFormatDemo().dateFormat(1000);
            System.out.println(date);
        }).start();
    }

    public String dateFormat(int seconds){
        //从1970-01-01 00:00:00开始计算
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        log.info("构造好的日期数据为:{}",dateFormat.format(date));
        return dateFormat.format(date);
    }

}
