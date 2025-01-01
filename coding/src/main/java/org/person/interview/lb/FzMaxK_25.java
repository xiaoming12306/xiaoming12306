package org.person.interview.lb;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k
 * 的整数倍，那么请将最后剩余的节点保持原有顺序。 你不能只是单纯的改变节点内部的值， 而是需要实际进行节点交换。 1 -> 2 -> 3 -> 4 ->5 k=2 2 -> 1 -> 4 -> 3
 * ->5
 */
public class FzMaxK_25 {

  public static class ListNode {
    int var;
    ListNode next;

    ListNode() {}

    ListNode(int var) {
      this.var = var;
    }

    ListNode(int var, ListNode next) {
      this.var = var;
      this.next = next;
    }
  }

  // 递归
  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    int length = 0;
    while (cur != null) {
      ++length;
      cur = cur.next;
    }
    if (k > length) {
      return head;
    }

    ListNode pre = head;
    ListNode curr = head.next;
    for (int i = 0; i < k - 1; i++) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }

    head.next = reverseKGroup(curr, k);
    return pre;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head_new = reverseKGroup(node1, 2);
    System.out.println(head_new);
  }
}
