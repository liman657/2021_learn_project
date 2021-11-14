package com.learn.concurrency.juclearn.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * autor:liman
 * createtime:2021/11/13
 * comment:读写锁的升降级实例
 */
public class ReadWriteLockUpdateAndDemote {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //创建出读写锁
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
//        new Thread(()->readDataUpdating()).start();
        new Thread(()->writeDataDemoting()).start();
    }

    private static void readDataUpdating(){
        String currentThreadName = Thread.currentThread().getName();
        readLock.lock();
        try{
            System.out.println(currentThreadName+"得到了读锁");
            //在持有读锁的前提下，尝试获取写锁，看是否能锁升级
            writeLock.lock();
            //始终无法输出，因为锁升级并不会成功，会让当前线程进入阻塞
            System.out.println(currentThreadName+"在持有读锁的情况下得到了写锁，升级成功");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
            System.out.println(currentThreadName+"释放了读锁");
        }
    }

    public static void writeDataDemoting(){
        String currentThreadName = Thread.currentThread().getName();
        writeLock.lock();
        try{
            System.out.println(currentThreadName+"得到了写锁");
            //在得到写锁的情况写继续获取读锁，看是否能够降级
            readLock.lock();
            //会输出这句话，锁降级是会成功的
            System.out.println(currentThreadName+"在持有写锁的情况下得到了读锁，降级成功");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
            System.out.println(currentThreadName+"释放了写锁");
        }
    }
}
