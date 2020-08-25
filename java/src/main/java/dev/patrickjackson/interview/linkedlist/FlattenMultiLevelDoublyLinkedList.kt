package dev.patrickjackson.interview.linkedlist

import java.util.ArrayDeque

/**
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Example:
1---2---3---4---5---6--NULL
|
7---8---9---10--NULL
|
11--12--NULL

https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */

/**
 * Solution #1 recursion
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 */
fun flatten(root: DoublyLinkedList.Node<Int>?): DoublyLinkedList.Node<Int>? {
    root ?: return null

    val sentinelHead = DoublyLinkedList.Node(0)
    sentinelHead.next = root

    flattenDfs(sentinelHead, root)

    sentinelHead.next?.prev = null
    return sentinelHead.next
}

private fun flattenDfs(
    prev: DoublyLinkedList.Node<Int>?,
    curr: DoublyLinkedList.Node<Int>?
): DoublyLinkedList.Node<Int>? {
    curr ?: return prev
    curr.prev = prev
    prev?.next = curr

    val tmpNext = curr.next

    val tail = flattenDfs(curr, curr.child)
    curr.child = null

    return flattenDfs(tail, tmpNext)
}

/**
 * Solution #2 iterative
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 */
fun flattenIterative(root: DoublyLinkedList.Node<Int>?): DoublyLinkedList.Node<Int>? {
    root ?: return null
    val sentinelHead = DoublyLinkedList.Node(0)
    var curr = sentinelHead
    var prev = sentinelHead
    val stack = ArrayDeque<DoublyLinkedList.Node<Int>>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        curr = stack.pop()
        prev.next = curr
        curr.prev = prev
        if (curr.next != null)
            stack.push(curr.next)
        if (curr.child != null) {
            stack.push(curr.child)
            curr.child = null
        }
        prev = curr
    }

    sentinelHead.next?.prev = null
    return sentinelHead.next
}
