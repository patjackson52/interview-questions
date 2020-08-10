package dev.patrickjackson.interview.linkedlist

import java.lang.IllegalStateException

class LinkedList<T>(var head: LinkedListNode<T>? = null) {

    data class LinkedListNode<T>(
            val value: T,
            var next: LinkedListNode<T>? = null
    )

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, throw IllegalStateException
     * Time Complexity O(N)
     */
    fun get(index: Int): LinkedListNode<T>? {
        var curr: LinkedListNode<T>? = head
        repeat(index) {
            curr = curr?.next ?: throw IllegalStateException("Node not found")
        }
        return curr
    }

    /**
     * Add a node before the first element of the linked list. After insertion, the new node
     * will be the first node of the linked list.
     * Time Complexity: O(1)
     */
    fun addAtHead(value: T) {
        val node = LinkedListNode(value)
        node.next = head
        head = node
    }

    /**
     * Append a node of value to the last element of the linked list.
     * Time Complexity: O(n)
     */
    fun addAtTail(value: T) {
        if (head == null) {
            head = LinkedListNode(value)
        }
        var prev: LinkedListNode<T>? = null
        var curr = head

        while (curr != null) {
            prev = curr
            curr = curr.next
        }
        if (prev != null)
            prev.next = LinkedListNode(value)
    }

    /**
     * Add a node before the index-th node in the linked list.  If index equals to the
     * length of the linked list, the node will be appended to the end of the linked list.
     * If index is greater than the length, the node will not be inserted.
     * Time Complexity: O(n)
     */
    fun addAtIndex(index: Int, value: T) {
        var prev = head
        var curr = head
        var ct = 0
        while(curr?.next != null && ct < index - 1) {
            ct++
            curr = curr.next
            prev = curr
        }

        if (prev != null) {
            prev.next = LinkedListNode(value, prev.next)
        } else if (index == ct){
            head = LinkedListNode(value, curr?.next)
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     * Time Complexity: O(n)
     */
    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            head = head?.next
            return
        }
        var prev = head
        var curr = head
        var ct = 0
        while (curr != null && ct < index) {
            prev = curr
            curr = curr.next
            ct++
        }
        if (curr != null)
            prev?.next = curr.next
    }

    override fun equals(other: Any?): Boolean {
        return if (other is LinkedList<*>) {
            var currThis = head
            var currOther = other.head
            if (currOther == null && currThis == null) return true
            while (currOther != null || currThis != null) {
                if (currOther?.value != currThis?.value)
                    return false
                currOther = currOther?.next
                currThis = currThis?.next
            }
            true
        } else {
            super.equals(other)
        }
    }

    override fun hashCode(): Int {
        return head?.hashCode() ?: 0
    }
}