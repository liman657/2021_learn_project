package com.learn.concurrency.foundataion.threadobjectcommonmethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/9/14
 * comment: 用wait和notify实现生产者和消费者
 */
public class ProducerConsumerModel {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        new Thread(producer).start();
        new Thread(consumer).start();
    }


}

class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class EventStorage{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage(){
        maxSize = 10;
        storage = new LinkedList<>();
    }

    /**
     * 往容器中放入元素
     */
    public synchronized void put(){

        while(storage.size() == maxSize){//如果仓库已经满了，则循环等待，wait释放锁
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.add(new Date());
        System.out.println("仓库里有了"+storage.size()+"个产品");
        notify();//通知消费者取元素，这里为了简单，只有一个消费者，因此直接notify
    }

    /**
     * 消费元素的方法
     */
    public synchronized void take(){
        while(storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了"+storage.poll()+"，现在仓库还剩下："+storage.size());
        notify();//通知生产者，生产数据
    }

}
