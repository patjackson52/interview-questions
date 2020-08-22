package dev.patrickjackson.interview.linkedlist

/**
Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.

Example:
 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4

https://leetcode.com/problems/merge-two-sorted-lists/
 */
fun mergeTwoLists(l1: LinkedList<Int>?, l2: LinkedList<Int>?): LinkedList<Int> {
    val sentinel = LinkedList.Node(0)
    var curr1 = l1?.head
    var curr2 = l2?.head
    var prev: LinkedList.Node<Int>? = sentinel

    while (curr1 != null && curr2 != null) {
        if (curr1.value <= curr2.value) {
            prev?.next = curr1
            curr1 = curr1.next
        } else {
            prev?.next = curr2
            curr2 = curr2.next
        }
        prev = prev?.next
    }
    prev?.next = curr1 ?: curr2

    return LinkedList(sentinel.next)
}
