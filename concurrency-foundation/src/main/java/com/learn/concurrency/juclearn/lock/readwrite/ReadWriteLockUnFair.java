package com.learn.concurrency.juclearn.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:读写锁实例，非公平情况下写锁可以任意插队
 */
public class ReadWriteLockUnFair {

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
