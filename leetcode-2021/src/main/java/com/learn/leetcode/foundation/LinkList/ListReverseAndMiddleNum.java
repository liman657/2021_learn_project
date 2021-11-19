package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * createtime:2020/2/2
 * comment:两个实例，一个是链表翻转，另一个是链表的中间数
 */
public class ListReverseAndMiddleNum {

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

        SelfLinkedList.traverse(node01);
//        SelfLinkedList.traverse(reverseList(node01));
        ListNode reverseNode = reverseList(node01);
        SelfLinkedList.traverse(reverseNode);
        System.out.println(getMiddleNode(reverseNode).value);

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

    /**
     * 取中间节点，如果链表长度是奇数，则直接取中间的。
     * 如果是偶数则取中间的前一个。
     * 定义两个指针，快指针每次走两步，慢指针每次走一步，当快指针走到尾的时候，
     * 慢指针则为中间节点。
     * @param head
     * @return
     */
    public static ListNode getMiddleNode(ListNode head){
        if(head==null){
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode.next!=null && fastNode.next.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

}
