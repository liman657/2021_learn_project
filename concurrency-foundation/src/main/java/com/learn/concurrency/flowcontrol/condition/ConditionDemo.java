package com.learn.concurrency.flowcontrol.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:普通的condition用法实例
 */
@Slf4j
public class ConditionDemo {

    private ReentrantLock lock = new ReentrantLock();
    //condition由锁来实例化
    private Condition condition = lock.newCondition();

    public void method01(){
        lock.lock();
        try{
            System.out.println("条件不满足，开始await");
            condition.await();
            System.out.println("条件满足，开始继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method02(){
        lock.lock();
        try{
            System.out.println("准备工作完成，唤醒其他线程");
            condition.signal();//唤醒在condition上等待的线程
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(()->{
            try {
                Thread.sleep(1000);
                conditionDemo.method02();//唤醒在condition上等待的线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //主线程调用method01先行阻塞，在1秒之后，被上面新建的线程唤醒
        conditionDemo.method01();
    }
}