package dev.patrickjackson.interview.linkedlist

/**
 Write a program to find the node at which the intersection of two singly linked lists begins.

 - If the two linked lists have no intersection at all, return null.
 - The linked lists must retain their original structure after the function returns.
 - You may assume there are no cycles anywhere in the entire linked structure.
 - Each value on each linked list is in the range [1, 10^9].
 - Your code should preferably run in O(n) time and use only O(1) memory.

 https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
fun <T> getIntersectionNode(headA: LinkedList<T>?, headB: LinkedList<T>?): LinkedList.Node<T>? {
    var ptrA = headA?.head
    var ptrB = headB?.head
    var hasConnectedA = false
    var hasConnectedB = false
    while (ptrA != null && ptrB != null) {
        if (ptrA === ptrB) return ptrA
        ptrA = ptrA.next
        ptrB = ptrB.next
        if (ptrA == null && !hasConnectedA) {
            ptrA = headB?.head
            hasConnectedA = true
        }
        if (ptrB == null && !hasConnectedB) {
            ptrB = headA?.head
            hasConnectedB = true
        }
    }
    return null
}
