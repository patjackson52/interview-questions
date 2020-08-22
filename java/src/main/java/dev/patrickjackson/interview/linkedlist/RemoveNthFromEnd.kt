package dev.patrickjackson.interview.linkedlist

/**
Given a linked list, remove the n-th node from the end of list and return its head.

Given n will always be valid.

Follow up:

Could you do this in one pass?

https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
fun removeNthFromEnd(head: LinkedList.Node<Int>?, n: Int): LinkedList.Node<Int>? {
    val dummy = LinkedList.Node(0)
    dummy.next = head
    var first: LinkedList.Node<Int>? = dummy
    var second: LinkedList.Node<Int>? = dummy

    repeat(n + 1) { first = first?.next }

    while (first != null) {
        first = first?.next
        second = second?.next
    }
    second?.next = second?.next?.next
    return dummy.next
}
