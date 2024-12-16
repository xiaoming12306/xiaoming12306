package org.person.interview.链表;

/** 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 1 -> 1 -> 1 -> 2 -> 3 ==> 2 -> 3 */
public class RmDuplicate_82 {

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

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    // 定义一个哑铃节点，避免head 头节点被删除
    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    // 判断 是否为最终的节点
    while (cur.next != null && cur.next.next != null) {
      // 判断是否相等
      if (cur.next.val == cur.next.next.val) {
        int x = cur.next.val;
        // 判断后续节点是否等于 x
        while (cur.next != null && cur.next.val == x) {
          // 迭代全部删除
          cur.next = cur.next.next;
        }
      } else {
        // 直接迭代后续指针
        cur = cur.next;
      }
    }
    // 去除全部哑铃节点
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode node5 = new ListNode(3, null);
    ListNode node4 = new ListNode(2, node5);
    ListNode node3 = new ListNode(1, node4);
    ListNode node2 = new ListNode(1, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head_new = deleteDuplicates(node1);
    System.out.println(head_new);
  }
}
