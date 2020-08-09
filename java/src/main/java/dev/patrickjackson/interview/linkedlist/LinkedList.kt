package dev.patrickjackson.interview.linkedlist

import java.lang.IllegalStateException

data class LinkedListNode<T>(
        val value: T,
        var next: LinkedListNode<T>? = null
) {
    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, throw IllegalStateException
     * Time Complexity O(N)
     */
    fun get(index: Int): LinkedListNode<T>? {
        var curr: LinkedListNode<T>? = this
        repeat(index) {
            curr = curr?.next ?: throw IllegalStateException("Node not found")
        }
        return curr
    }
}