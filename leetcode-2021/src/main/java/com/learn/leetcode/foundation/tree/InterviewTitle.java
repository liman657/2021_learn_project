package com.learn.leetcode.foundation.tree;

import java.util.HashMap;

/**
 * autor:liman
 * createtime:2020/2/7
 * comment:根据中序和先序数组重构二叉树
 * leetcode 105
 */
public class InterviewTitle {

    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        if(preOrder == null || inOrder == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return buildTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,map);
    }

    /**
     *  根据中序和先序遍历的数组构建一个二叉树
     * @param preOrder
     * @param pStart
     * @param pEnd
     * @param inOrder
     * @param iStart
     * @param iEnd
     * @param map
     * @return
     */
    public TreeNode buildTree(int[] preOrder,int pStart,int pEnd,
                              int[] inOrder,int iStart,int iEnd,
                              HashMap<Integer,Integer> map){
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }

        TreeNode head = new TreeNode(preOrder[pStart]+"");
        int index = map.get(preOrder[pStart]);//找到根节点在中序遍历中的位置
        head.left = buildTree(preOrder,pStart+1,pStart+index-iStart,inOrder,iStart,index-1,map);
        head.right = buildTree(preOrder,pStart+index-iStart+1,pEnd,inOrder,index+1,iEnd,map);
        return head;

    }

    public static void main(String[] args) {

    }

}
