package com.learn.concurrency.juclearn.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:读写锁实例
 */
public class ReadWriteLock {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //创建出读写锁
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        Thread threadOne = new Thread(()->{readData();},"read-1");
        Thread threadTwo = new Thread(()->{readData();},"read-2");
        Thread threadThree = new Thread(()->{writeData();},"write-1");
        Thread threadFour = new Thread(()->{writeData();},"write-2");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();

    }

    private static void readData(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了读锁");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了读锁");
        }
    }

    public static void writeData(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到了写锁");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了写锁");
        }
    }
}
