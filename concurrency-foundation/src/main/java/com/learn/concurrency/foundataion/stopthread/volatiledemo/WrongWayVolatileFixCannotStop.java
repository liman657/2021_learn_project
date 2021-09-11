package com.learn.concurrency.foundataion.stopthread.volatiledemo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * autor:liman
 * createtime:2021/9/11
 * comment: interrupt解决WrongWayVolatileCannotStop中，消费者不会消费全部生产者数据，产生的中断问题
 */
@Slf4j
public class WrongWayVolatileFixCannotStop {
    public static void main(String[] args) throws InterruptedException {

        WrongWayVolatileFixCannotStop body = new WrongWayVolatileFixCannotStop();

        ArrayBlockingQueue dataQueue = new ArrayBlockingQueue(10);
        Producer producer = body.new Producer(dataQueue);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(10000);//让生产者生产数据

        Consumer consumer = body.new Consumer(dataQueue);
        while(consumer.canConsumer(dataQueue)){
            log.info("数据:{} 被消费者消费了",consumer.dataQueue.take());
            Thread.sleep(100);//模拟消费者对获取到的数据进行处理
        }
        log.info("消费者消费数据完成（不再需要更多数据），给生产者发送中断信号");
        producerThread.interrupt();
    }

    class Producer implements Runnable{

        BlockingQueue dataQueue;

        public Producer(BlockingQueue dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 100000 && !Thread.currentThread().isInterrupted()) {
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
}
