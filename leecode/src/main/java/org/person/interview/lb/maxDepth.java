package main.java.org.person.interview.lb;

public class maxDepth {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftDepth = maxDepth(root.left);
      int rightDepth = maxDepth(root.right);
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
