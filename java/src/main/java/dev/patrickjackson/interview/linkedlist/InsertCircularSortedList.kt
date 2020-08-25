package dev.patrickjackson.interview.linkedlist

/**
Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 */
fun insert(head: LinkedList.Node<Int>?, insertVal: Int): LinkedList.Node<Int>? {
    if (head == null) {
        val newNode = LinkedList.Node(insertVal)
        newNode.next = newNode
        return newNode
    }

    var prev = head!!
    var curr = head.next!!
    var toInsert = false

    do {
        if (prev.value <= insertVal && insertVal <= curr.value) {
            toInsert = true
        } else if (prev.value > curr.value) {
            if (insertVal >= prev.value || insertVal <= curr.value)
                toInsert = true
        }

        if (toInsert) {
            prev.next = LinkedList.Node(insertVal)
            prev.next?.next = curr
            return head
        }
        prev = curr
        curr = curr.next!!
    } while (prev != head)

    prev.next = LinkedList.Node(insertVal)
    prev.next?.next = curr
    return head
}
