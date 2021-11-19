package com.learn.leetcode.arrayandlist;

import com.learn.leetcode.foundation.LinkList.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021-11-19
 * comment:LeetCode第24题
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * Example : 1->2->3->4
 * Result:2->1->4->3
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Input: head = []
 * Output: []
 * Input: head = [1]
 * Output: [1]
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
@Slf4j
public class SwapNodesInPairs_24 {

    public static void main(String[] args) {

    }

    public ListNode initListNode(){
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        node01.next=node02;
        node02.next=node03;
        node03.next=node04;
        node04.next=null;
        return node01;
    }

}
