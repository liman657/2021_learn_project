package com.learn.leetcode.foundation.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * autor:liman
 * createtime:2020/2/7
 * comment:二叉树的最大深度和最小深度
 */
public class BinTreeDeep {

    /**
     * 递归计算最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;//毕竟根节点还是要算一层高度的。
    }

    /**
     * 非递归实现最大深度，要用到层序遍历
     *
     * @param root
     * @return
     */
    public int maxDepthLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    /**
     * 递归求树的最小深度，这里需要考虑的条件更多
     *
     * @param root
     * @return
     */
    public int mixDepth(TreeNode root) {
        if (root == null) {//树为空
            return 0;
        }
        if (root.left == null && root.right == null) {//只有一个根节点
            return 1;
        }
        if (root.left == null && root.right != null) {
            return mixDepth(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return mixDepth(root.left) + 1;
        }

        //这个就是左子树和右子树都不为空的情况
        int left = mixDepth(root.left);
        int right = mixDepth(root.right);
        return Math.min(left,right)+1;

    }

    public int mixDepthLevel(TreeNode root){
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                //第一个左右子树为空的节点的层高，必是最小深度
                if(node.left== null && node.right == null){
                    return level;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        BinTreeDeep binTreeDeep = new BinTreeDeep();
        System.out.println(binTreeDeep.maxDepth(A));
        System.out.println(binTreeDeep.maxDepthLevel(A));
        System.out.println(binTreeDeep.mixDepth(A));
        System.out.println(binTreeDeep.mixDepthLevel(A));
    }

}
