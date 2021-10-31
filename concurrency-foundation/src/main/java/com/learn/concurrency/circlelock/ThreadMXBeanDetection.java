package com.learn.concurrency.circlelock;

import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;

/**
 * autor:liman
 * createtime:2021-10-30
 * comment:用ThreadMXBean 检测死锁
 */
public class ThreadMXBeanDetection implements Runnable {

    int flag = 1;
    static Object object01 = new Object();
    static Object object02 = new Object();

    public static void main(String[] args) {
        SimpleDeadLockDemo deadLockDemo01 = new SimpleDeadLockDemo();
        SimpleDeadLockDemo deadLockDemo02 = new SimpleDeadLockDemo();
        deadLockDemo01.flag = 1;
        deadLockDemo02.flag = 0;
        Thread thread01 = new Thread(deadLockDemo01);
        Thread thread02 = new Thread(deadLockDemo02);
        thread01.start();
        thread02.start();
        //主线程等待1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开始检测死锁
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //返回发生死锁的线程ID数组
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (null != deadlockedThreads && deadlockedThreads.length > 0) {
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println(threadInfo.getThreadName()+"发生死锁");
                String lockName = threadInfo.getLockName();
                System.out.println("相关的锁信息为"+lockName);
            }
        }

    }

    @Override
    public void run() {
        System.out.println("当前的flag=" + flag);
        if (1 == flag) {
            synchronized (object01) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object02) {
                    System.out.println("escape dead lock,flag:1");
                }
            }
        } else {
            synchronized (object02) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object01) {
                    System.out.println("escape dead lock,flag:1");
                }
            }
        }
    }
}
