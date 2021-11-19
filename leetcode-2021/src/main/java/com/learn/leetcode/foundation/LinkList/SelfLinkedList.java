package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * comment:
 */
public class SelfLinkedList {

    /**
     * 头结点的插入
     * @param head
     * @param newHead
     */
    public static void headInsert(ListNode head,ListNode newHead){
        ListNode old = head;
        head = newHead;
        head.next = old;
    }

    /**
     * 未节点的插入
     * @param tail
     * @param newTail
     */
    public static void tailInsert(ListNode tail,ListNode newTail){
        ListNode old = tail;
        tail = newTail;
        newTail.next = null;
        old.next = tail;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void traverse(ListNode head){
        while(head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 查找节点，返回节点索引
     * @param head
     * @return
     */
    public static int findNode(ListNode head,int value){
        int index = -1;
        int count = 0;
        while(head!=null){
            if(head.value == value){
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    /**
     * 在pre节点的后面插入s节点
     * @param pre
     * @param s
     */
    public static void insertAfterNode(ListNode pre,ListNode s){
        ListNode pAfter = pre.next;
        pre.next = s;
        s.next = pAfter;
    }

    /**
     * 删除节点s，将s的next复制到s,然后删除s的后继节点
     * @param head
     * @param s
     */
    public static void deleteNode(ListNode head,ListNode s){
        if(s!=null && s.next!=null){//这里不包含删除尾节点的情况
            ListNode sNext = s.next;
            s.value = sNext.value;
            //删除s的下一个节点
            s.next = sNext.next;
            sNext=null;
        }

        //如果是删除尾节点
        if(s.next==null){
            //遍历找打前驱
            while(head!=null){
                if(head.next!=null && head.next == s){
                    head.next=null;
                    break;
                }
                head=head.next;
            }
        }
    }

}
