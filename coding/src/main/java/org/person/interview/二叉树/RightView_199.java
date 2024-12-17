package org.person.interview.二叉树;

import java.util.ArrayList;
import java.util.List;

/** 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 */
public class RightView_199 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, 0, ans);
    return ans;
  }

  private static void dfs(TreeNode root, int depth, List<Integer> ans) {
    if (root == null) {
      return;
    }
    if (depth == ans.size()) {
      ans.add(root.val);
    }
    dfs(root.right, depth + 1, ans);
    dfs(root.left, depth + 1, ans);
  }

  public static void main(String[] args) {
    // 构建第一个测试用二叉树
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);

    root1.left = node2;
    root1.right = node3;
    node2.right = node5;
    node3.right = node6;
    node2.left = node4;

    RightView_199 rightView1 = new RightView_199();
    List<Integer> result1 = rightView1.rightSideView(root1);
    System.out.println("第一个二叉树从右侧看到的节点值为: " + result1);
  }
}
