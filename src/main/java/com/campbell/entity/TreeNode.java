package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2021/11/15
 */
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

    }

    public static void preGet(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.println(node.data);
        preGet(node.left);
        preGet(node.right);
    }

    public static void add(int num) {

    }
}
