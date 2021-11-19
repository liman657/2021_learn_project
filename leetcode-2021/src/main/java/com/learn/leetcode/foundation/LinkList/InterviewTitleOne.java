package com.learn.leetcode.foundation.LinkList;

/**
 * autor:liman
 * createtime:2020/2/4
 * comment:面试题
 * 一个链表，奇数位升序，偶数位降序，对该链表进行排序
 */
public class InterviewTitleOne {

    /**
     * 分成三步：
     * 1、按照奇数位和偶数位进行拆分
     * 2、对偶数位进行翻转
     * 3、合并排序
     */
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

        ListNode[] listNodes = getList(node01);
        ListNode head01 = listNodes[0];
        ListNode head02 = listNodes[1];
        //翻转偶数位的链表
        head02=reverseList(head02);

        ListNode result = mergetList(head01,head02);
        SelfLinkedList.traverse(result);

    }

    /**
     * 拆分链表，按奇偶进行拆分
     *
     * @param head
     * @return
     */
    public static ListNode[] getList(ListNode head) {
        ListNode head01 = null;
        ListNode head02 = null;

        ListNode cur01 = null;
        ListNode cur02 = null;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {//奇数节点
                if(cur01!=null){
                    cur01.next = head;
                    cur01 = cur01.next;
                }else{
                    cur01 = head;
                    head01 = cur01;
                }
            }else{
                if(cur02!=null){
                    cur02.next = head;
                    cur02 = cur02.next;
                }else{
                    cur02 = head;
                    head02 = cur02;
                }
            }
            head = head.next;
            count++;
        }
        cur01.next = null;
        cur02.next = null;
        ListNode[] nodes = new ListNode[]{head01,head02};
        return nodes;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 合并两个链表
     * @param head01
     * @param head02
     * @return
     */
    public static ListNode mergetList(ListNode head01,ListNode head02){
        if(head01 == null && head02 ==null){
            return null;
        }
        if(head01==null){
            return head02;
        }
        if(head02 == null){
            return head01;
        }
        ListNode head = null;
        if(head01.value>head02.value){
            head=head02;
            head.next = mergetList(head01,head02.next);
        }else{
            head = head01;
            head.next = mergetList(head01.next,head02);
        }
        return head;
    }

}
