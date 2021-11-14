package com.learn.concurrency.juclearn.lock.readwrite;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:读写锁实例，非公平情况下读锁有一定几率可以插队（在等待队列中不是写数据的线程）
 */
public class ReadWriteLockReadBarge {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);//false构造非公平锁

    //创建出读写锁
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        new Thread(()->{writeData();},"write-1").start();
        new Thread(()->{readData();},"read-1").start();
        new Thread(()->{readData();},"read-2").start();
        new Thread(()->{writeData();},"write-2").start();
        new Thread(()->{readData();},"read-3").start();
        //创造可以插队的读线程
//        new Thread(()->{
            Thread thread[]=new Thread[1000];
            for(int i=0;i<1000;i++){
                thread[i] = new Thread(()->readData(),"BargeSubThread"+i);
            }
            Arrays.stream(thread).forEach(Thread::start);
//        }).start();
    }

    private static void readData(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName+"尝试获取读锁");
        readLock.lock();
        try{
            System.out.println(currentThreadName+"得到了读锁，开始读取数据");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
            System.out.println(currentThreadName+"释放了读锁");
        }
    }

    public static void writeData(){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName+"尝试获取写锁");
        writeLock.lock();
        try{
            System.out.println(currentThreadName+"得到了写锁");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
            System.out.println(currentThreadName+"释放了写锁");
        }
    }
}
