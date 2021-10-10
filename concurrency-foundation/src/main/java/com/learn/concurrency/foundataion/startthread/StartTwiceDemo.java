package com.learn.concurrency.foundataion.startthread;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/10/7
 * comment:启动两次的线程
 */
@Slf4j
public class StartTwiceDemo {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }

}
