package com.learn.concurrency.foundataion.threadcoreknowledge;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/7
 * comment:继承thread创建线程
 */
@Slf4j
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        Thread thread = new ThreadStyle();
        thread.start();
    }

    @Override
    public void run() {
        log.info("继承Thread类的方式实现线程");
    }
}
