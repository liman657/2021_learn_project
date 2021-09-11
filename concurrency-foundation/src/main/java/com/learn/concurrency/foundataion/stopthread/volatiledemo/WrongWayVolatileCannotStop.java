package com.learn.concurrency.foundataion.stopthread.volatiledemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment: volatile的局限性，无法停止线程的实例
 * 当线程阻塞的时候，volatile无法停止线程
 * 生产者生产数据很快，消费者消费数据很慢，所以阻塞队列满了之后，生产者会阻塞，这种情况 volatile是不生效的
 */
@Slf4j
public class WrongWayVolatileCannotStop{

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue dataQueue = new ArrayBlockingQueue(10);
        Producer producer = new Producer(dataQueue);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(10000);//让生产者生产数据

        Consumer consumer = new Consumer(dataQueue);
        while(consumer.canConsumer(dataQueue)){
            log.info("数据:{} 被消费者消费了",consumer.dataQueue.take());
            Thread.sleep(100);//模拟消费者对获取到的数据进行处理
        }
        log.info("消费者消费数据完成，给生产者发送中断信号");

        producer.canceled = true;//消费者数据消费完成，停止生产者
    }


}

@Slf4j
class Producer implements Runnable{

    public volatile boolean canceled = false;

    BlockingQueue dataQueue;

    public Producer(BlockingQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 100 == 0) {
                    dataQueue.put(num);//数据放入队列
                    log.info("num : {} 是100的倍数", num);
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("【生产者】运行结束");
        }
    }
}

@Slf4j
class Consumer{

    BlockingQueue dataQueue;

    public Consumer(BlockingQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    /**
     * 判断是否能进一步的消费数据
     * @param dataQueue
     * @return
     */
    public boolean canConsumer(BlockingQueue dataQueue){
        //if(dataQueue.size()<=0){
        if(Math.random()>0.95){//消费者不需要太多数据，不一定会消费所有生产者的数据
            return false;
        }
        return true;
    }
}