package com.learn.springsourcedemo.demo.pattern.callback;

/**
 * autor:liman
 * createtime:2021/5/31
 * comment: 回调函数的实例
 *
 */
public class CallBackDemo {

    /**
     * 这个实例里面，Thread就是组件的意思，run方法其实就是回调函数
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("子线程开始休眠2s");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程被回调");
        });

        thread.start();
    }

}
