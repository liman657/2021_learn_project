package com.learn.concurrency.foundataion.threadobjectcommonmethods;

/**
 * autor:liman
 * createtime:2021/9/19
 * comment:join的底层原理解析，分析出join的代替写法
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        });

        thread1.start();
        System.out.println("主线程开始等待子线程运行完毕");
        //这里的join由子线程的对象进行调用，但含义实质是将子线程加入到主线程中
        //thread1.join();//含义：子线程加入到主线程中，主线程需要等待子线程执行完毕之后再运行
        //thread1.join的等价代码，主线程获取到thread1这个对象锁之后，进入等待
        //最后被thread1的run方法执行结束之后，被唤醒
        synchronized (thread1){
            thread1.wait();
        }
        System.out.println("所有子线程执行完毕");
    }

}
