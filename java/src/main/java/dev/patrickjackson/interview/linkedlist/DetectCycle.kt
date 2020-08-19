package dev.patrickjackson.interview.linkedlist
/*
  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

  To represent a cycle in the given linked list, we use an integer pos which represents the position
  (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in
  the linked list.

  Note: Do not modify the linked list.

  https://leetcode.com/problems/linked-list-cycle-ii/
 */
fun <T> detectCycle(linkedList: LinkedList<T>?): LinkedList.Node<T>? {
    val head = linkedList?.head ?: return null

    val interceptNode = getIntersect(head) ?: return null

    var ptr1: LinkedList.Node<T>? = head
    var ptr2: LinkedList.Node<T>? = interceptNode

    while (ptr1 != ptr2) {
        ptr1 = ptr1?.next
        ptr2 = ptr2?.next
    }
    return ptr1
}

private fun <T> getIntersect(node: LinkedList.Node<T>): LinkedList.Node<T>? {
    var tortoise: LinkedList.Node<T>? = node
    var hare: LinkedList.Node<T>? = node

    while (hare?.next != null) {
        tortoise = tortoise?.next
        hare = hare.next?.next
        if (tortoise == hare) return tortoise
    }
    return null
}
