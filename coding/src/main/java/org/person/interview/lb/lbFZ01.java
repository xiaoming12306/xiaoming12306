package org.person.interview.lb;

/** 链表反转 */
public class lbFZ01 {

  static class ListNode {
    int val; // 定义当前值
    ListNode next; // 定义链表

    ListNode(int x, ListNode next) { // 定义函数
      val = x;
      this.next = next;
    }
  }
  // 迭代
  public static ListNode reverseList(ListNode head) {
    ListNode prev = null; // 当前节点前一个节点
    ListNode current = head; // 当前节点
    while (current != null) {
      ListNode nextTemp = current.next; // 当前节点下一个节点
      current.next = prev;
      prev = current;
      current = nextTemp;
    }
    return prev;
  }

  // 递归
  public static ListNode reverseList1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode head_new = reverseList1(head.next);
    head.next.next = head;
    head.next = null;
    return head_new;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    //        ListNode rev = reverseList(node1);
    ListNode rev = reverseList1(node1);
    System.out.println(rev);
  }
}
