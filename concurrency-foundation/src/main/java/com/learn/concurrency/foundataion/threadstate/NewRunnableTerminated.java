package com.learn.concurrency.foundataion.threadstate;

        import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment:展示线程的new runnable terminated状态
 */
@Slf4j
public class NewRunnableTerminated implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());//NEW
        thread.start();
        System.out.println(thread.getState());//刚开始，不一定有资源，也是RUNNABLE
        Thread.sleep(5);
        System.out.println(thread.getState());//打印线程正在运行的状态——RUNNABLE
        Thread.sleep(10);
        System.out.println(thread.getState());//TERMINATED
    }

}
