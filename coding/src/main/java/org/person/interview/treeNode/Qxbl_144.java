package org.person.interview.treeNode;

import java.util.ArrayList;
import java.util.List;

public class Qxbl_144 {
  // 1. 定义二叉树类
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
  /**
   * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
   *
   * @param root
   * @return
   */
  // 递归实现
  // 思路：
  // 定义 preorder(root) 表示当前遍历到 root 节点的答案。按照定义，我们只要首先将 root 节点的值加入答案，
  // 然后递归调用 preorder(root.left) 来遍历 root 节点的左子树，
  // 最后递归调用 preorder(root.right) 来遍历 root 节点的右子树即可，递归终止的条件为碰到空节点。

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    // 递归 preorder
    preorder(root, res);
    return res;
  }

  private static void preorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val); // 添加根节点
    preorder(root.left, res); // 遍历左子树
    preorder(root.right, res); // 遍历右子树
  }

  public static void main(String[] args) {
    // 构建第一个测试用二叉树
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
    List<Integer> res = preorderTraversal(root1);
    System.out.println("前序遍历二叉树节点顺序: " + res);
  }
}
