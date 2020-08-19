package dev.patrickjackson.interview.linkedlist

/**
Given a linked list, determine if it has a cycle in it.
https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
*/
fun <T> hasCycle(linkedList: LinkedList<T>): Boolean {
    var fast = linkedList.head?.next
    var slow = linkedList.head

    while (fast != null) {
        if (fast.next == slow || fast.next?.next == slow)
            return true
        fast = fast.next?.next
        slow = slow?.next
    }

    return false
}
