package com.learn.leetcode.foundation.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * autor:liman
 * createtime:2020/2/6
 * comment:树的遍历操作，非递归实现
 */
public class TreeTraverse {

    /**
     * 非递归实现的先序遍历
     *
     * @param root
     */
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {//如果根节点不为空
            Stack<TreeNode> stack = new Stack<>();//非递归要用到栈
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                doTraverse(node);
                //先判断右子树，再判断左子树
                if (node.right != null) {//判断右子树，如果右子树不为空，入栈
                    stack.push(node.right);
                }
                if (node.left != null) {//判断左子树，如果左子树不空，则入栈
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 非递归实现中序遍历
     *
     * @param root
     */
    public static void innerOrderTraverse(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            //不断的入栈左子树
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    doTraverse(root);
                    root = root.right;
                }
            }

        }
    }

    /**
     * 非递归实现后序遍历，一个栈比较麻烦，两个栈相对简单
     *
     * @param root
     */
    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                stack2.push(pop);
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
            }
            while (!stack2.isEmpty()) {
                doTraverse(stack2.pop());
            }
        }
    }

    /**
     * 层次遍历，非递归实现
     *
     * @param root
     */
    public static void levelOrderTraverse(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);//root入队列
            while (!queue.isEmpty()) {
                //获取当前层次的节点
                int levelNum = queue.size();
                for (int i = 0; i < levelNum; i++) {
                    TreeNode node = queue.poll();
                    doTraverse(node);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
    }

    /**
     * 做遍历的操作。
     *
     * @param node
     */
    public static void doTraverse(TreeNode node) {
        System.out.print(node.value + " ");
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

        System.out.println("先序遍历:");
        preOrderTraverse(A);
        System.out.println();
        System.out.println("中序遍历:");
        innerOrderTraverse(A);
        System.out.println();
        System.out.println("后序遍历:");
        postOrderTraverse(A);
        System.out.println();
        System.out.println("层序遍历:");
        levelOrderTraverse(A);
    }

}
