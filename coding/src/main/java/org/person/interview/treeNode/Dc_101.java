package org.person.interview.treeNode;

public class Dc_101 {
    // 1. 定义二叉树
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return (root == null || dfs(root.left, root.right));
    }
    
    private static boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l== null || r == null || l.val != r.val) return false;
        return dfs(l.left, r.right) && dfs(l.right, r.left);
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
        System.out.println(isSymmetric(root1));
    }
}
