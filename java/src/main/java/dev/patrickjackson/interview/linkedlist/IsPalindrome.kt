package dev.patrickjackson.interview.linkedlist

/**
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

https://leetcode.com/problems/palindrome-linked-list/submissions/
 */
fun <T> isPalindrome(head: LinkedList.Node<T>?): Boolean {
    head ?: return true

    val firstHalfEnd = findEndOfFirstHalf(head)
    val secondHalfStart = reverseList(firstHalfEnd?.next)

    var p1: LinkedList.Node<T>? = head
    var p2: LinkedList.Node<T>? = secondHalfStart
    var result = true

    while (result && p2 != null) {
        if (p1?.value != p2.value)
            result = false
        p1 = p1?.next
        p2 = p2.next
    }

    firstHalfEnd?.next = reverseList(secondHalfStart)
    return result
}

private fun <T> reverseList(head: LinkedList.Node<T>?): LinkedList.Node<T>? {
    var prev: LinkedList.Node<T>? = null
    var curr = head
    while (curr != null) {
        val tmpNext = curr.next
        curr.next = prev
        prev = curr
        curr = tmpNext
    }
    return prev
}

private fun <T> findEndOfFirstHalf(node: LinkedList.Node<T>): LinkedList.Node<T>? {
    var fast: LinkedList.Node<T>? = node
    var slow: LinkedList.Node<T>? = node
    while (fast?.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}
