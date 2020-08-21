package dev.patrickjackson.interview.linkedlist

/**
Given a linked list, remove the n-th node from the end of list and return its head.

Given n will always be valid.

Follow up:

Could you do this in one pass?

https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
fun <T> removeNthFromEnd(head: LinkedList.Node<T>?, n: Int): LinkedList.Node<T>? {
    val dummy = LinkedList.Node<T>()
    dummy.next = head
    var first: LinkedList.Node<T>? = dummy
    var second: LinkedList.Node<T>? = dummy

    repeat(n + 1) { first = first?.next }

    while (first != null) {
        first = first?.next
        second = second?.next
    }
    second?.next = second?.next?.next
    return dummy.next
}
