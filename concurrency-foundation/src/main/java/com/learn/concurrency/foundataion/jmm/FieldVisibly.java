package com.learn.concurrency.foundataion.jmm;

/**
 * autor:liman
 * createtime:2021-10-22
 * comment:可见性实例，演示可见性带来的问题
 */
public class FieldVisibly {
    int a = 1;
    int b = 2;

    public void changeFieldValue() {
        a = 3;
        b = a;
    }

    private void printFieldValue() {
        System.out.println("a = " + a + ",b = " + b);
    }

    public static void main(String[] args) {
        FieldVisibly fieldVisibly = new FieldVisibly();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //try {
                //    Thread.sleep(1);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                fieldVisibly.changeFieldValue();
            }
        }).start();

        new Thread(()->{
            //try {
            //    Thread.sleep(1);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            fieldVisibly.printFieldValue();
        }).start();
    }
}
