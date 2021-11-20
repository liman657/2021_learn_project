package com.learn.concurrency.juclearn.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * autor:liman
 * createtime:2021/11/16
 * comment:将普通变量升级为原子变量
 */
public class AtomicIntegerFieldUpdateDemo implements Runnable{

    static Candidate tom;
    static Candidate peter;

    //构造的时候，第一个参数为Class，第二个为其中的属性名称
    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater
            =AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    //用于示例，静态内部类
    public static class Candidate{
        volatile int score;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            peter.score++;
            scoreUpdater.getAndIncrement(tom);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AtomicIntegerFieldUpdateDemo runnable = new AtomicIntegerFieldUpdateDemo();
        Thread threadOne = new Thread(runnable);
        Thread threadTwo = new Thread(runnable);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("普通的变量值："+peter.score);
        System.out.println("升级为原子类的变量值:"+tom.score);
    }
}
