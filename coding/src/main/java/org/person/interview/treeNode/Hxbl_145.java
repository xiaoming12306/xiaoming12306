package org.person.interview.treeNode;

import java.util.ArrayList;
import java.util.List;

public class Hxbl_145 {

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
  // 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历
  public static List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    post(root, res);
    return res;
  }

  private static void post(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }

    post(root.left, res);
    post(root.right, res);
    res.add(root.val);
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
    List<Integer> res = postorderTraversal(root1);
    System.out.println("后序遍历二叉树节点顺序: " + res);
  }
}
