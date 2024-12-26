package org.person.interview.链表;

/** 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 */
public class Sort_148 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head; // 空链表或只有一个节点，直接返回
    }

    // 1. 使用快慢指针找到终点
    ListNode mid = getMid(head);

    // 2. 将链表拆分为两部分
    ListNode rightHead = mid.next;
    mid.next = null; // 断开链表

    // 3. 递归排序左右两部分
    ListNode left = sortList(head);
    ListNode right = sortList(rightHead);

    // 4. 合并两个有序链表
    return merge(left, right);
  }

  private static ListNode getMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow; // 慢指针最终停在中点
  }

  private static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0); // 哨兵节点
    ListNode current = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }
    current.next = l1 != null ? l1 : l2;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(3, node5);
    ListNode node3 = new ListNode(6, node4);
    ListNode node2 = new ListNode(1, node3);
    ListNode node1 = new ListNode(2, node2);
    ListNode res = sortList(node1);
    System.out.println(res);
  }
}
