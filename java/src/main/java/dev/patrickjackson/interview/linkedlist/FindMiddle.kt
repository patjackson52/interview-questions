package dev.patrickjackson.interview.linkedlist

/**
 * Find the middle node of a LinkedList.
 *
 Given a non-empty, singly linked list with head node head, return a middle node of linked list.

 If there are two middle nodes, return the second middle node.

 https://leetcode.com/problems/middle-of-the-linked-list/
 */
fun <T> findMiddleNode(linkedList: LinkedList<T>): LinkedList.Node<T>? {
    linkedList.head ?: return null
    var slow: LinkedList.Node<T>? = linkedList.head
    var fast: LinkedList.Node<T>? = linkedList.head

    while (fast?.next != null) {
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
    var slow = linkedList.head
    var fast = linkedList.head
    var prevSlow: LinkedList.Node<T>? = null

    while (fast?.next != null) {
        fast = fast.next?.next
        prevSlow = slow
        slow = slow?.next
    }
    return prevSlow
}
