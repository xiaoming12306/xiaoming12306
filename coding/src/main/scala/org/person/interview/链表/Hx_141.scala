package org.person.interview.链表

abstract class ListNode {
  var next: ListNode
  var x: Int
}

object Hx_141 {

  /**
   * 给你一个链表的头节点 head ，判断链表中是否有环。
   *
   * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
   *
   * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
   *
   * @param head
   * @return
   */
  def hasCycle(head: ListNode): Boolean = {
    if (head == null) {
      return false
    }
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (fast == slow) {}
      return true
    }
    false
  }

  def main(args: Array[String]): Unit = {
    // 构建有环链表示例并测试
    val head2 = new ListNode {
      var next: ListNode = null
      var x: Int = 4
    }
    val node5 = new ListNode {
      var next: ListNode = null
      var x: Int = 5
    }
    val node6 = new ListNode {
      var next: ListNode = null
      var x: Int = 6
    }
    val node7 = new ListNode {
      var next: ListNode = null
      var x: Int = 7
    }
    head2.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node5 // 形成环
    val result2 = hasCycle(head2)
    println(s"有环链表测试结果: $result2")
  }
}
