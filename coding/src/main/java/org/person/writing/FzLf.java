package org.person.writing;

public class FzLf {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode fz(ListNode head) {
    // 1 -> 2 ->3
    // null <- 1 <- 2 <- 3
    // pre cur next
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    return pre;
  }

  public static void main(String[] args) {
    ListNode node3 = new ListNode(3);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode res = fz(node1);
    System.out.println(res);
  }
}
