package com.learn.leetcode.foundation.stackandqueue;

/**
 * autor:liman
 * createtime:2020/2/5
 * comment:队列的基本操作，基于数组实现（静态队列）
 * 循环队列的方式
 */
public class MyQueue {

    public int[] arrays;
    public int front;   //指向的是第一个有效的元素
    public int rear;    //指向的是最后一个有效元素的下一个元素

    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判断队列是否是满的
     *
     * @param queue
     * @return
     */
    public static boolean isFull(MyQueue queue) {
        if ((queue.rear + 1) % queue.arrays.length == queue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断队列是否是空
     *
     * @param queue
     * @return
     */
    public static boolean isEmpty(MyQueue queue) {
        if (queue.rear == queue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 入队操作
     *
     * @param queue
     * @param value
     */
    public static void enQueue(MyQueue queue, int value) {
        if (!isFull(queue)) {
            queue.arrays[queue.rear] = value;
            queue.rear = (queue.rear + 1) % queue.arrays.length;
        }
    }

    /**
     * 遍历操作
     *
     * @param queue
     */
    public static void traverse(MyQueue queue) {
        int i = queue.front;
        while (i != queue.rear) {
            System.out.println(queue.arrays[i]);
            i = (i + 1) % queue.arrays.length;
        }
    }

    public static void outQueue(MyQueue queue) {
        if (!isEmpty(queue)) {
            int value = queue.arrays[queue.front];
            System.out.println(value);
            queue.front = (queue.front + 1) % queue.arrays.length;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(new int[6],0,0);
        System.out.println(isEmpty(queue));

        enQueue(queue,1);
        enQueue(queue,2);
        enQueue(queue,3);
        enQueue(queue,4);
        enQueue(queue,5);
        System.out.println(isFull(queue));

        traverse(queue);

        outQueue(queue);
        outQueue(queue);
//        traverse(queue);
    }
}
