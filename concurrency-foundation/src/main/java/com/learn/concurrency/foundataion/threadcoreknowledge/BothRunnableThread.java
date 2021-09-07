package com.learn.concurrency.foundataion.threadcoreknowledge;

import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/9/7
 * comment:同时使用两种方式实现线程
 */
@Slf4j
public class BothRunnableThread  {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是Runnable方式创建的线程");
            }
        }){
            //由于本身的run方法被重写过，因此通过runnable对象创建的时候，父类Thread中的run方法已经被重写了
            @Override
            public void run() {
                System.out.println("这是继承Thread创建的线程");//输出这一行
            }
        }.start();
    }
}
