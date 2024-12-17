package org.person.interview.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 */
public class LevelTra_102 {
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

  public static List<List<Integer>> levelOrder(TreeNode root) {
    // 算法流程：
    //
    //    特例处理： 当根节点为空，则返回空列表 [] 。
    //    初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] 。
    //    BFS 循环： 当队列 queue 为空时跳出。
    //        新建一个临时列表 tmp ，用于存储当前层打印结果。
    //        当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）。
    //            出队： 队首元素出队，记为 node。
    //            打印： 将 node.val 添加至 tmp 尾部。
    //            添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue 。
    //        将当前层结果 tmp 添加入 res 。
    //    返回值： 返回打印结果列表 res 即可。

    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root != null) {
      queue.add(root);
    }

    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      for (int i = queue.size(); i > 0; i--) {
        TreeNode node = queue.poll();
        tmp.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(tmp);
    }
    return res;
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

    System.out.println(levelOrder(root1));
  }
}
