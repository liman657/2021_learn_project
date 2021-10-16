package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/19
 * comment:先join再mainThread.getState();
 */
public class JoinThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("主线程join期间的状态：" + mainThread.getState());//这里输出的是主线程join时候的状态
                System.out.println(Thread.currentThread().getName() + "运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        System.out.println("主线程等待子线运行完毕");
        thread.join();
        System.out.println("主线程运行完毕");
    }
}
