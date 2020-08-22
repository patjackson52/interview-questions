package dev.patrickjackson.interview.linkedlist

/**
 Remove all elements from a linked list of integers that have value @param value.

 https://leetcode.com/problems/remove-linked-list-elements/
 */
fun removeElements(head: LinkedList.Node<Int>?, value: Int): LinkedList.Node<Int>? {
    val sentinel = LinkedList.Node<Int>(0)
    sentinel.next = head
    var prev: LinkedList.Node<Int>? = sentinel
    var curr = head
    while (curr != null) {
        if (curr.value == value)
            prev?.next = curr.next
        else
            prev = curr
        curr = curr.next
    }
    return sentinel.next
}
