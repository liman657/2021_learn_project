package com.learn.concurrency.finallearn;

/**
 * autor:liman
 * createtime:2021/11/20
 * comment:栈封闭实例
 */
public class StackConfinement implements Runnable{

    int index = 0;

    public void innerThreadMethod(){
        int neverGoOut = 0;
        for(int i=0;i<10000;i++){
            neverGoOut++;
        }
        System.out.println("栈内保护的数字是线程安全的："+neverGoOut);
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            index++;
        }
        innerThreadMethod();
    }

    public static void main(String[] args) throws InterruptedException {
        StackConfinement run = new StackConfinement();
        Thread threadOne = new Thread(run);
        Thread threadTwo = new Thread(run);
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println(run.index);
    }
}
