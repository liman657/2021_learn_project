package com.learn.concurrency.foundataion.uncaughtexception;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/20
 * comment:自定义的线程异常处理器
 */
@Slf4j
public class SelfThreadExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
       //这里就是我们自己的线程异常处理类
       log.error("线程:{},运行出现异常，异常信息为:{},请进行处理",t.getName(),e.getMessage());
    }
}
