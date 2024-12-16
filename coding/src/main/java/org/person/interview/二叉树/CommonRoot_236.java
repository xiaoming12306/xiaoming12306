package org.person.interview.二叉树;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class CommonRoot_236 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null) return right;
    if (right == null) return left;
    return root;
  }

  public static void main(String[] args) {
    // 构建第一个测试用的二叉树示例
    TreeNode root1 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);
    TreeNode node6 = new TreeNode(6);
    TreeNode node2 = new TreeNode(2);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);
    TreeNode node7 = new TreeNode(7);
    TreeNode node4 = new TreeNode(4);

    root1.left = node5;
    root1.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    // 查找节点5和节点1的最近公共祖先，预期结果为节点3
    TreeNode result1 = lowestCommonAncestor(root1, node5, node1);
    System.out.println("节点5和节点1的最近公共祖先: " + (result1 != null ? result1.val : null));

    // 查找节点6和节点4的最近公共祖先，预期结果为节点5
    TreeNode result2 = lowestCommonAncestor(root1, node6, node4);
    System.out.println("节点6和节点4的最近公共祖先: " + (result2 != null ? result2.val : null));

    // 构建第二个测试用的二叉树示例（简单二叉树）
    TreeNode root2 = new TreeNode(1);
    TreeNode leftNode = new TreeNode(2);
    TreeNode rightNode = new TreeNode(3);

    root2.left = leftNode;
    root2.right = rightNode;

    // 查找节点2和节点3的最近公共祖先，预期结果为节点1
    TreeNode result3 = lowestCommonAncestor(root2, leftNode, rightNode);
    System.out.println("节点2和节点3的最近公共祖先: " + (result3 != null ? result3.val : null));
  }
}
