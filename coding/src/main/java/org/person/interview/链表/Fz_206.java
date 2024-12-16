package org.person.interview.链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。 示例 1： 1 -> 2 -> 3 -> 4 -> 5 5 -> 4 -> 3 -> 2 -> 1 输入：head =
 * [1,2,3,4,5] 输出：[5,4,3,2,1] 提示： 链表中节点的数目范围是 [0, 5000] -5000 <= Node.val <= 5000
 */
public class Fz_206 {

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
  // pre - curr - next
  // 迭代方法
  public static ListNode reverseListNode(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }
  // 递归法
  // head - next
  public static ListNode reverseListNodeDG(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode head_new = reverseListNodeDG(head.next);
    // 关键步骤 将指针从head-next 变成 next-head
    head.next.next = head;
    // null->head  变成 head -> null
    head.next = null;
    return head_new;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode rev = reverseListNode(node1);
    System.out.println(rev);
  }
}
