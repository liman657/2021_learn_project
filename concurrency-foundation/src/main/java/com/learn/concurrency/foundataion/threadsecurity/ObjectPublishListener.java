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
            @Override
            public void onEvent(Event e) {
                System.out.println("我得到的数字是" + count);
            }
        });

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        count = 100;
    }

    public static void main(String[] args) {

    }

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
