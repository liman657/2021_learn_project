package com.learn.concurrency.juclearn.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * autor:liman
 * createtime:2021/11/16
 * comment:AtomicIntegerArray的类型
 */
@Slf4j
public class AtomicArrayDemo {

    public static void main(String[] args) throws InterruptedException {
        //1000个AtomicInteger的数组集合
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        Thread[] incrementThread = new Thread[100];
        Thread[] decrementThread = new Thread[100];
        for(int i=0;i<100;i++){
            incrementThread[i] = new Thread(incrementer);
            decrementThread[i] = new Thread(decrementer);
        }

        Arrays.stream(incrementThread).forEach(Thread::start);
        Arrays.stream(decrementThread).forEach(Thread::start);
        for(int i=0;i<100;i++){
            incrementThread[i].join();
            decrementThread[i].join();
        }
        for(int i=0;i<atomicIntegerArray.length();i++){
            if(atomicIntegerArray.get(i)!=0){
                System.out.println("发现异常");
            }
        }
        System.out.println("运行结束");
    }

}

class Decrementer implements Runnable {

    private AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for(int i=0;i<array.length();i++){
            array.getAndDecrement(i);//对第i个元素减1
        }
    }
}

class Incrementer implements Runnable {

    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for(int i=0;i<array.length();i++){
            array.getAndIncrement(i);//对第i个元素减1
        }
    }
}
