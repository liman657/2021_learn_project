package com.learn.concurrency.foundataion.threadsecurity;

/**
 * autor:liman
 * createtime:2021/9/27
 * comment: 监听器的异常修复，用工厂模式修复
 */
public class ObjectPublishListenerThreadFix {

    int count;
    private EventListener eventListener;

    public static ObjectPublishListenerThreadFix getInstance(MySource mySource){
        //初始化完成之后，再注册监听器
        ObjectPublishListenerThreadFix listenerThreadFix = new ObjectPublishListenerThreadFix(mySource);
        mySource.registerListener(listenerThreadFix.eventListener);
        return listenerThreadFix;
    }

    private ObjectPublishListenerThreadFix(MySource mySource) {
        eventListener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.print("我得到的数字是" + count);
            }
        };

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
        ObjectPublishListenerThreadFix objectPublishListener = new ObjectPublishListenerThreadFix(source);
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
