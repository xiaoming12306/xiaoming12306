package org.person.interview.treeNode;

import java.util.HashMap;

/** 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。 */
public class PreorderAndInorder_105 {
  public static int[] preorder;
  public static HashMap<Integer, Integer> dic = new HashMap<>();

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

  public static TreeNode buildTree(int[] preorder1, int[] inorder) {
    preorder = preorder1;
    for (int i = 0; i < inorder.length; i++) dic.put(inorder[i], i);
    return recur(0, 0, inorder.length - 1);
  }

  public static TreeNode recur(int root, int left, int right) {
    if (left > right) return null;
    TreeNode node = new TreeNode(preorder[root]);
    int i = dic.get(preorder[root]); // 划分根节点、左子树、右子树
    node.left = recur(root + 1, left, i - 1); // 开启左子树递归
    node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
    return node;
  }

  public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    System.out.println(buildTree(preorder, inorder));
  }
}
