package com.learn.concurrency.juclearn.lock.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:可重入锁递归调用
 */
@Slf4j
public class RecursionDemo {

    private static ReentrantLock lock = new ReentrantLock();

    private static void accessResource(){
        lock.lock();
        try{
            System.out.println("对资源进行处理");
            if(lock.getHoldCount()<5){
                System.out.println("处理次数未达到5次，再次递归进行处理");
                accessResource();
            }else{
                System.out.println("处理次数足够");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        accessResource();
    }

}
