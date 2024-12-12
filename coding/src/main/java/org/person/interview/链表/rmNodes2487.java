package org.person.interview.链表;

/** 给你一个链表的头节点 head 。 移除每个右侧有一个更大数值的节点。 返回修改后链表的头节点 head。 5 -> 2 -> 13 -> 3 -> 8 ==> 13 -> 8 */
public class rmNodes2487 {
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

  public static ListNode removeNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    head.next = removeNodes(head.next);
    if (head.next != null && head.var < head.next.var) {
      return head.next;
    } else {
      return head;
    }
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(8, null);
    ListNode node4 = new ListNode(3, node5);
    ListNode node3 = new ListNode(13, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(5, node2);
    ListNode head_new = removeNodes(node1);
    System.out.println(head_new.toString());
  }
}
