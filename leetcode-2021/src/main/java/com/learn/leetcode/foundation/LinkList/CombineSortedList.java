package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * createtime:2020/2/2
 * comment:合并两个有序链表
 * 有两种方式，递归和遍历
 */
public class CombineSortedList {

    public static void main(String[] args) {
        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(1);
//        ListNode node03 = new ListNode(3);
//        ListNode node04 = new ListNode(5);
//        ListNode node05 = new ListNode(6);
//        node01.next = node03;
//        node02.next = node04;
//        node03.next = node05;

//        ListNode mergeList = mergeTwoListRecursive(node01,node02);
//        ListNode mergeList = mergeTwoList(node01,node02);
        ListNode mergeList = mergeTwoListSelf(node01,node02);

        SelfLinkedList.traverse(mergeList);
    }

    /**
     * 递归的方式合并有序链表
     *
     * @param head01
     * @param head02
     * @return
     */
    public static ListNode mergeTwoListRecursive(ListNode head01, ListNode head02) {
        //递归出口
        if (head01 == null && head02 == null) {
            return null;
        }
        if (head01 == null) {
            return head02;
        }
        if (head02 == null) {
            return head01;
        }

        ListNode head = null;//合并后的头节点
        if (head01.value > head02.value) {
            head = head02;
            head.next = mergeTwoListRecursive(head01, head02.next);
        } else {
            head = head01;
            head.next = mergeTwoListRecursive(head01.next, head02);
        }
        return head;
    }

    /**
     * 非递归合并两个链表。
     *
     * @param head01
     * @param head02
     * @return
     */
    public static ListNode mergeTwoList(ListNode head01, ListNode head02) {
        if (head01 == null || head02 == null) {
            return head01 != null ? head01 : head02;
        }

        ListNode head = head01.value <= head02.value ? head01 : head02;
        ListNode cur1 = head == head01 ? head01 : head02;
        ListNode cur2 = head == head01 ? head02 : head01;

        ListNode pre = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {//cur1<cur2，则将cur1合并入
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;   //预先保存
                pre.next = cur2;
                cur2.next = cur1;   //这个操作不是很懂
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    /**
     * 合并链表，自己的思想，和当时的数据结构书籍上的处理一样
     *
     * @param head01
     * @param head02
     * @return
     */
    public static ListNode mergeTwoListSelf(ListNode head01, ListNode head02) {
        if (head01 == null || head02 == null) {
            return head01 != null ? head01 : head02;
        }
        ListNode pNode = new ListNode(-65535);//建立一个节点用于头节点
        ListNode head = head01.value <= head02.value ? head01 : head02;//构建head,后面的构建操作，交给了pNode
        ListNode cur01 = head01;
        ListNode cur02 = head02;
        while (cur01 != null && cur02 != null) {
            if (cur01.value <= cur02.value) {
                pNode.next = cur01;
                cur01 = cur01.next;
            } else {
                pNode.next = cur02;
                cur02 = cur02.next;
            }
            pNode = pNode.next;
        }

        pNode.next = cur01 == null ? cur02 : cur01;
        return head;
    }
}
