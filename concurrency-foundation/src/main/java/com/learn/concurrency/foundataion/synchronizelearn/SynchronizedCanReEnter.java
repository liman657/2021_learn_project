package com.learn.concurrency.foundataion.synchronizelearn;

/**
 * autor:liman
 * createtime:2021-10-17
 * comment:synchronized可重入
 */
public class SynchronizedCanReEnter {

    int a = 0;

    public synchronized void method01(){
        System.out.println("这里是method01,a="+a);
        if(0==a){
            a++;
            method01();
        }
        method02();
    }

    public synchronized void method02(){
        System.out.println("这里是method02");
    }

    public static void main(String[] args) {
        SynchronizedCanReEnter synchronizedCanReEnter = new SynchronizedCanReEnter();
        synchronizedCanReEnter.method01();
    }
}
