package com.learn.concurrency.collections.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import javax.naming.PartialResultException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * autor:liman
 * createtime:2021/11/24
 * comment:有界，需要指定容量，可以指定公平还是不公平
 * 实例：10个面试者，一个面试官，一个休息室有三个位置
 */
@Slf4j
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        Interviewer interviewer = new Interviewer(arrayBlockingQueue);
        Consumer consumer = new Consumer(arrayBlockingQueue);
        new Thread(interviewer).start();
        new Thread(consumer).start();
    }


}

//模拟的是面试者
class Interviewer implements Runnable {
    private BlockingQueue queue;

    public Interviewer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("10个候选人都来了");
        for (int i = 0; i < 10; i++) {
            String candidate = "Candidate" + (i+1);
            try {
                queue.put(candidate);
                System.out.println("候选人" + (i + 1) + "等待面试");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            //结束的标志位
            queue.put("allin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者模拟的是面试官
class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = "";
        try {
            while (!((msg = queue.take()).equals("allin"))) {
                System.out.println(msg + "正在面试");
            }
            System.out.println("所有候选人都面试完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}