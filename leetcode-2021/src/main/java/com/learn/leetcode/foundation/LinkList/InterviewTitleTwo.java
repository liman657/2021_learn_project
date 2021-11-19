package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * createtime:2020/2/4
 * leetcode:148
 * comment: 单链表归并排序
 * 归并排序应该算是链表排序最佳的选择了，保证了最好和最好的时间复杂度都是nlogn，
 * 而且归并排序在数组中空间复杂度为O(n)，在链表中也变成了O(1)
 * <p>
 * 思路：
 * 1、将待排序的数组（链表）一分为二
 * 2、递归的将左边部分进行归并排序
 * 3、递归的将右边部分进行归并排序
 * 4、将两个部分进行合并排序，得到结果。
 * <p>
 * 找到中间节点，利用快慢指针即可。
 */
public class InterviewTitleTwo {

    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(8);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(6);
        ListNode node05 = new ListNode(5);
        ListNode node06 = new ListNode(4);
        ListNode node07 = new ListNode(7);
        ListNode node08 = new ListNode(2);
        ListNode node09 = new ListNode(9);

        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        node06.next = node07;
        node07.next = node08;
        node08.next = node09;

        ListNode sortedList = sortList(node01);
        SelfLinkedList.traverse(sortedList);
    }

    /**
     * 链表的归并排序算法
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next==null) {//0个或者1个元素，不用排序，直接返回
            return head;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode rightFirst = middleNode.next;
        middleNode.next=null;//拆成两个链表；
        ListNode node=CombineSortedList.mergeTwoListSelf(sortList(head),sortList(rightFirst));
        return node;
    }

    /**
     * 获取中间节点
     *
     * @param head
     * @return
     */
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        System.out.println(slowNode.value);
        return slowNode;
    }

    /**
     * 非递归有序合并两个链表
     *
     * @param head01
     * @param head02
     * @return
     */
    public static ListNode merge(ListNode head01, ListNode head02) {
        if (head01 == null || head02 == null) {
            return head01 != null ? head01 : head02;
        }

        ListNode head = head01.value <= head02.value ? head01 : head02;
        ListNode cur1 = head == head01 ? head01 : head02;
        ListNode cur2 = head == head01 ? head02 : head01;

        ListNode pre = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
