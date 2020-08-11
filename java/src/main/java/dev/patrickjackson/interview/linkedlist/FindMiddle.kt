package dev.patrickjackson.interview.linkedlist

/**
 * Find the middle node of a LinkedList.
 *
   Given a non-empty, singly linked list with head node head, return a middle node of linked list.

   If there are two middle nodes, return the second middle node.

   https://leetcode.com/problems/middle-of-the-linked-list/
 */
fun <T> findMiddleNode(linkedList: LinkedList<T>): LinkedList.LinkedListNode<T>? {
    var fast = linkedList.head?.next
    var slow = linkedList.head
    while (fast != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    return slow
}