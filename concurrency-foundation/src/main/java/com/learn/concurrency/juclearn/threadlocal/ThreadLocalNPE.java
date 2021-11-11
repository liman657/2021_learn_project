package com.learn.concurrency.juclearn.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/11/11
 * comment: ThreadLocal nullpointException的问题
 */
@Slf4j
public class ThreadLocalNPE {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());//当前的线程id作为value
    }

    public Long get(){
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE= new ThreadLocalNPE();
//        threadLocalNPE.set();
        System.out.println("ThreadLocal value:"+threadLocalNPE.get());

        Thread threadOne = new Thread(()->{
            threadLocalNPE.set();
            System.out.println("sub thread id : "+threadLocalNPE.get());
        });
        threadOne.start();
    }

}
