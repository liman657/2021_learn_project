package com.learn.concurrency.flowcontrol.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * autor:liman
 * createtime:2021/11/28
 * comment:condition实现生产者和消费者
 */
@Slf4j
public class ConditionProducerAndCustomer {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    class Customer extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while(true){//消费者一直消费
                lock.lock();
                try{
                    while(queue.size() == 0){
                        System.out.println("队列为空，消费者进入等待");
                        try {
                            notEmpty.await();//用notEmpty进行等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    notFull.signal();//取出数据，同志爱生产者继续生产
                    System.out.println("从队列取走了一个数据，队列剩余"+queue.size()+"个数据");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce(){
            while(true){//生产者一直生产
                lock.lock();
                try{
                    while(queue.size() == queueSize){
                        System.out.println("队列已满，生产者进入等待");
                        try {
                            notFull.await();//用 notFull 进行等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(new Random().nextInt(100));
                    notEmpty.signalAll();//取出数据，同志爱生产者继续生产
                    System.out.println("生产者向消费者插入了一个数据，队列剩余"+queue.size()+"个数据");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ConditionProducerAndCustomer conditionProducerAndCustomer = new ConditionProducerAndCustomer();
        Producer producer = conditionProducerAndCustomer.new Producer();
        Customer customer = conditionProducerAndCustomer.new Customer();
        customer.start();
        producer.start();
    }
}