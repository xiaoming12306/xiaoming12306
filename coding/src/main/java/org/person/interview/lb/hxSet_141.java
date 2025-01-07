package org.person.interview.lb;

import java.util.HashSet;
import java.util.Set;

public class hxSet_141 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static boolean hasCycle(ListNode head) {

    ListNode cur = head;
    Set<ListNode> res = new HashSet<>();
    while (cur != null) {
      if (!res.add(cur)) {
        return true;
      }
      cur = cur.next;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(5, node2);

    System.out.println(hasCycle(node1));
  }
}
