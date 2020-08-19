package dev.patrickjackson.interview.linkedlist

/**
 * Find the middle node of a LinkedList.
 *
 Given a non-empty, singly linked list with head node head, return a middle node of linked list.

 If there are two middle nodes, return the second middle node.

 https://leetcode.com/problems/middle-of-the-linked-list/
 */
fun <T> findMiddleNode(linkedList: LinkedList<T>): LinkedList.Node<T>? {
    var fast = linkedList.head?.next
    var slow = linkedList.head
    while (fast != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    return slow
}

/**
 * Returns the node BEFORE the center.
 * Useful for creating two lists.
 */
fun <T> findNodeBeforeMiddle(linkedList: LinkedList<T>): LinkedList.Node<T>? {
    var fast = linkedList.head?.next
    var slow = linkedList.head
    var slowPrev: LinkedList.Node<T>? = null
    while (fast != null) {
        fast = fast.next?.next
        slowPrev = slow
        slow = slow?.next
    }

    return slowPrev
}
