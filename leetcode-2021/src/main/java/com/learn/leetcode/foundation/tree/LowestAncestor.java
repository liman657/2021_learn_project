package com.learn.leetcode.foundation.tree;

/**
 * autor:liman
 * createtime:2020/2/7
 * comment: 求二叉树两个节点最近的祖先
 */
public class LowestAncestor {

    /**
     * 递归实现两个节点最近的祖先
     * @param root
     * @param node01
     * @param node02
     * @return
     */
    public TreeNode lowestCommoAncestor(TreeNode root, TreeNode node01, TreeNode node02) {

        //最近的公共祖先是root节点
        if (root == null || root == node01 || root == node02) {
            return root;
        }

        TreeNode left = lowestCommoAncestor(root.left, node01, node02);
        TreeNode right = lowestCommoAncestor(root.right, node01, node02);

        if (left != null && right != null) {//如果左右都不空，说明两边均能找到node01和node02，则公共节点只能root了
            return root;
        }

        //如果只有一个为空，则那个公共的祖先就是这个节点。
        return left != null ? left : right;
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

        LowestAncestor lowestAncestor = new LowestAncestor();
        TreeNode root = lowestAncestor.lowestCommoAncestor(A, B, F);
        System.out.println(root.value);
    }

}
