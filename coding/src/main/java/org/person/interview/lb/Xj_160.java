package org.person.interview.lb;

import java.util.HashSet;

/** 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。 */
public class Xj_160 {

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

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      a = a != null ? a.next : headB;
      b = b != null ? b.next : headA;
    }
    return a;
  }

  public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    // 1. 定义一个HashSet<ListNode>
    HashSet<ListNode> set = new HashSet<>();
    // 2. 遍历headA 存储在set
    ListNode curA = headA;
    while (curA != null) {
      set.add(curA);
      curA = curA.next;
    }

    // 3. 遍历headB, 判断是否有相交点
    ListNode curB = headB;
    while (curB != null) {
      if (set.contains(curB)) {
        return curB;
      }
      curB = curB.next;
    }

    // 4. 没有相交 返回null
    return null;
  }

  public static void main(String[] args) {
    ListNode aNode5 = new ListNode(5, null);
    ListNode aNode4 = new ListNode(4, aNode5);
    ListNode aNode3 = new ListNode(8, aNode4);
    ListNode aNode2 = new ListNode(1, aNode3);
    ListNode aNode1 = new ListNode(4, aNode2);

    ListNode bNode5 = new ListNode(5, null);
    ListNode bNode4 = new ListNode(4, bNode5);
    ListNode bNode3 = new ListNode(8, bNode4);
    ListNode bNode2 = new ListNode(2, bNode3);
    ListNode bNode1 = new ListNode(3, bNode2);

    System.out.println(getIntersectionNode(aNode1, bNode1));
    //    System.out.println(getIntersectionNode1(aNode1, bNode1));
  }
}
