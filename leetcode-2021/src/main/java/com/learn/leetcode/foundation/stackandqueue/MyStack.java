package com.learn.leetcode.foundation.stackandqueue;

import com.learn.LinkList.ListNode;

/**
 * autor:liman
 * createtime:2020/2/5
 * comment: 栈，自己的栈操作，底层采用链表的数据结构
 */
public class MyStack {

    private ListNode stackTop;
    private ListNode stackBottom;

    public MyStack(ListNode stackTop,ListNode stackBottom){
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * 入栈操作
     * @param stack
     * @param value
     */
    public static void pushStack(MyStack stack,int value){
        ListNode node = new ListNode(value);
        node.next = stack.stackTop;
        stack.stackTop=node;
    }

    /**
     * 遍历操作
     * @param stack
     */
    public static void traverse(MyStack stack){
        ListNode stackTop = stack.stackTop;
        while(stackTop!=stack.stackBottom){
            System.out.print(stackTop.value +" ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    /**
     * 栈的判空操作
     * @param stack
     * @return
     */
    public static boolean isEmpty(MyStack stack){
        if(stack.stackTop == stack.stackBottom){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 出栈
     * @param stack
     */
    public static void popStack(MyStack stack){
        if(!isEmpty(stack)){
            ListNode stackTop = stack.stackTop;
            stack.stackTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    /**
     * 清空栈中的元素
     * @param stack
     */
    public static void clearStack(MyStack stack){
        stack.stackTop = null;
        stack.stackBottom = stack.stackTop;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack(new ListNode(0),new ListNode(10));
        stack.stackBottom = stack.stackTop;
        System.out.println(isEmpty(stack));
        pushStack(stack,2);
        pushStack(stack,3);
        pushStack(stack,5);
        traverse(stack);
        System.out.println(isEmpty(stack));

        popStack(stack);
        clearStack(stack);
        System.out.println(isEmpty(stack));
    }

}
