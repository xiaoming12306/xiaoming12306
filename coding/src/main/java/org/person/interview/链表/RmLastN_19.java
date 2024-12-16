package org.person.interview.链表;

/** 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 1 -> 2 -> 3 -> 4 -> 5 ==> 3 1 -> 2 -> 3 -> 5 */
public class RmLastN_19 {

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

  public static ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode dummy = new ListNode(0, head);
    int length = getLength(head);
    ListNode cur = dummy;

    for (int i = 1; i < length - n + 1; i++) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    ListNode ans = dummy.next;
    return ans;
  }

  public static int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      ++length;
      head = head.next;
    }

    return length;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head_new = removeNthFromEnd(node1, 2);
    System.out.println(head_new);
  }
}
