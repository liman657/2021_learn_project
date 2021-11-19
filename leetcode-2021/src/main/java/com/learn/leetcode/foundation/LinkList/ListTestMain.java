package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * createtime:2020/2/2
 * comment: 链表测试实例代码
 */
public class ListTestMain {

    public static void main(String[] args) {

        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);

        node01.next=node02;
        node02.next=node03;
        node03.next=node04;
        node04.next=node05;
        node05.next=null;

        //测试遍历
        SelfLinkedList.traverse(node01);

        //测试头插入
        ListNode node0 = new ListNode(0);
        SelfLinkedList.headInsert(node01,node0);
        SelfLinkedList.traverse(node0);

        //测试尾插入
        ListNode newTail = new ListNode(999);
        SelfLinkedList.insertAfterNode(node05,newTail);
        SelfLinkedList.traverse(node0);

        //查找
        int index = SelfLinkedList.findNode(node0, 3);
        System.out.println(index);

        //插入
        ListNode insertNode = new ListNode(888);
        SelfLinkedList.insertAfterNode(node03,insertNode);
        SelfLinkedList.traverse(node0);

        //测试删除
        SelfLinkedList.deleteNode(node0,insertNode);
        SelfLinkedList.traverse(node0);
    }

}
