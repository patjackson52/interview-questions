package dev.patrickjackson.interview.linkedlist

/**
 Remove all elements from a linked list of integers that have value @param value.

 https://leetcode.com/problems/remove-linked-list-elements/
 */
fun <T> removeElements(head: LinkedList.Node<T>?, value: Int): LinkedList.Node<T>? {
    val sentinel = LinkedList.Node<T>()
    sentinel.next = head
    var prev: LinkedList.Node<T>? = sentinel
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
