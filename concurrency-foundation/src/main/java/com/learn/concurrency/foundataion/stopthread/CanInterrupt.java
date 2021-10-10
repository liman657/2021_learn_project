package com.learn.concurrency.foundataion.stopthread;

/**
 * autor:liman
 * createtime:2021/9/9
 * comment:while里头放try/catch，则会导致中断失效
 */
public class CanInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            while(num <= 10000 && !Thread.currentThread().isInterrupted()){
                if(num % 100 == 0){
                    System.out.println(num + " is 100 的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);//sleep响应中断，catch处理之后，会复位中断标志位
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
