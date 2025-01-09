package org.person.interview.treeNode;

public class MaxDepth_104 {

  // 1. 定义二叉树
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  // 给定一个二叉树 root ，返回其最大深度。
  // 二叉树的最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    root1.left = node2;
    root1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;
    int res = maxDepth(root1);
    System.out.println(res);
  }
}
