package org.person.interview.链表;

/** 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 1 -> 1 -> 2 ==> 1 -> 2 */
public class rmNodes83 {

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

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode cur = head;
    while (cur.next != null) {
      if (cur.var == cur.next.var) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode node3 = new ListNode(2, null);
    ListNode node2 = new ListNode(1, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head_new = deleteDuplicates(node1);
    System.out.println(head_new);
  }
}
