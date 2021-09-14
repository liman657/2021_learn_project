package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment:wait和notifyAll的实例
 * notify是随机唤醒一个阻塞线程
 * notifyAll是唤醒所有阻塞线程
 * 这个实例有三个线程，两个线程阻塞，一个线程用于唤醒
 * start 先执行，不代表线程先启动
 */
public class WaitNotifyAllDemo implements Runnable{

    private static final Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"获取到资源锁");
            try {
                System.out.println("线程即将wait "+Thread.currentThread().getName());
                resourceA.wait();//wait释放锁
                System.out.println("线程"+Thread.currentThread().getName()+"被唤醒继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAllDemo();
        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);
        Thread thread03 = new Thread(()->{
            synchronized (resourceA){
                resourceA.notifyAll();
                System.out.println(Thread.currentThread().getName()+"notify all thread");
            }
        });
        thread01.start();
        thread02.start();
        Thread.sleep(500);
        thread03.start();
    }
}
