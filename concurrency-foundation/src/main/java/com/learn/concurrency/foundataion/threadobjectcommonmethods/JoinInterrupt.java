package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/19
 * comment:join遇到中断的实例
 */
public class JoinInterrupt {

    public static void main(String[] args) {
        //拿到主线程的引用
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(() -> {
            try {
                //在子线程中中断主线程
                mainThread.interrupt();
                Thread.sleep(5000);

                System.out.println(Thread.currentThread().getName()+"运行完毕");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"线程中断");
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println("开始等待子线程运行");
        try {
            thread.join();//含义：thread加入到主线程中，主线程等待thread执行完成
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"线程被中断了");//主线程被中断了
            e.printStackTrace();
            thread.interrupt();//如果主线程在join期间中断，规范的操作是将这个中断传递给子线程
        }
        System.out.println("主线程等待子线程执行完毕");
    }

}
