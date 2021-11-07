package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * autor:liman
 * createtime:2021/11/7
 * comment:简单的ThreadLocal实例
 */
@Slf4j
public class SimpleThreadLocalDemo {

    public static void main(String[] args) {

    }

    public String dateFormat(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return "";
    }

}
