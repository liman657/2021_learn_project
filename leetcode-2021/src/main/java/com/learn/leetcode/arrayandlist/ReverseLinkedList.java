package com.learn.leetcode.arrayandlist;

import com.learn.leetcode.foundation.LinkList.ListNode;

/**
 * autor:liman
 * createtime:2021-11-19
 * comment:LeetCode第206题，翻转链表
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 翻转链表，时间复杂度O(n),空间复杂度O(1)
     *
     * @param head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode afterNode = null;
        while (head != null){
            afterNode = head.next;
            head.next=preNode;
            preNode = head;
            head = afterNode;
        }
        return preNode;
    }

}
