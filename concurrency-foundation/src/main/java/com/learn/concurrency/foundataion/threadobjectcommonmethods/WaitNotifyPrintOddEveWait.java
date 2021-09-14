package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment:用wait方法打印奇偶数
 */
public class WaitNotifyPrintOddEveWait {

    private static int count = 0;
    private static final Object lock = new Object();

    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己休眠
    static class TurningRunner implements Runnable{

        @Override
        public void run() {
            while(count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();
                    if(count<=100){
                        try {
                            //如果任务还没结束，就让出当前的锁，自己休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TurningRunner(),"偶数").start();
        //Thread.sleep(100);可以休眠一下，防止奇偶错乱
        new Thread(new TurningRunner(),"奇数").start();
    }
}