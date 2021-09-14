package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment: wait只释放其拥有的锁
 */
public class WaitNotifyReleaseOwnMonitor {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
           synchronized (resourceA){
               System.out.println(Thread.currentThread().getName()+" get resourceA lock");
               synchronized (resourceB){
                   System.out.println(Thread.currentThread().getName()+" get resourceB lock");
                   try {
                       System.out.println(Thread.currentThread().getName()+ "release resourceA lock");
                       resourceA.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA){
                System.out.println(Thread.currentThread().getName()+" other thread  get resourceA lock");
                System.out.println(Thread.currentThread().getName()+" other thread try to get resourceB lock");
                synchronized (resourceB){//这个线程无法打印这行日志，因为wait只是释放指定对象的锁，并不会释放线程持有的所有锁
                    System.out.println(Thread.currentThread().getName()+" other thread get resourceB lock");
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}
