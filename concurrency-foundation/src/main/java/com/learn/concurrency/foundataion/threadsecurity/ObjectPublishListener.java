package com.learn.concurrency.foundataion.threadsecurity;

/**
 * autor:liman
 * createtime:2021/9/27
 * comment: 比较隐晦的，监听器的时候，对象未初始化完成
 */
public class ObjectPublishListener {

    int count;

    public ObjectPublishListener(MySource mySource) {
        mySource.registerListener(new EventListener() {
            //这里需要访问外部的count，但是这里过早的暴露了EventListener对象，过早的操作没有初始化完成的count，会产生相关问题。
            @Override
            public void onEvent(Event e) {
                System.out.print("我得到的数字是" + count);
            }
        });

        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
        }
        System.out.println();
        count = 100;
    }

    public static void main(String[] args) {
        MySource source = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                source.eventTriger(new Event(){});
            }
        }).start();

        //这里调用构造函数，构造函数里头会完成监听器的注册，
        ObjectPublishListener objectPublishListener = new ObjectPublishListener(source);
    }

    /**
     * 事件源
     */
    static class MySource {
        private EventListener eventListener;

        void registerListener(EventListener eventListener) {
            this.eventListener = eventListener;
        }

        void eventTriger(Event e) {
            if (null != eventListener) {
                eventListener.onEvent(e);
            } else {
                System.out.println("还未初始化完成");
            }
        }
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {

    }
}
