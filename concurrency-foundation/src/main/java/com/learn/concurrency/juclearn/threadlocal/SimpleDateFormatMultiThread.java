package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * autor:liman
 * createtime:2021/11/8
 * comment:多个线程打印SimpleDateFormat转换的日期格式
 */
@Slf4j
public class SimpleDateFormatMultiThread {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(()->{
                String date = new SimpleDateFormatMultiThread().dateFormat(finalI);
                System.out.println(date);
            }).start();
        }
    }

    public String dateFormat(int seconds) {
        //从1970-01-01 00:00:00开始计算
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
