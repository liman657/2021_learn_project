package com.learn.leetcode.foundation.stackandqueue;

import java.util.Stack;

/**
 * autor:liman
 * createtime:2020/2/5
 * comment:利用两个栈实现队列
 */
public class DoubleStack2Queue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public DoubleStack2Queue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value){
        stackPush.push(value);
    }

    /**
     * 出队列的操作
     * @return
     */
    public int poll(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){//队列为空
            throw new RuntimeException("队列为空");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /**
     * 只是单纯的读取栈顶的元素
     * @return
     */
    public int peek(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){//队列为空
            throw new RuntimeException("队列为空");
        }else if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        DoubleStack2Queue doubleStack2Queue =
                new DoubleStack2Queue(new Stack<Integer>(),new Stack<Integer>());

        doubleStack2Queue.add(1);
        doubleStack2Queue.add(2);
        doubleStack2Queue.add(3);

        System.out.println(doubleStack2Queue.peek());
        doubleStack2Queue.poll();
        System.out.println(doubleStack2Queue.peek());

    }

}
