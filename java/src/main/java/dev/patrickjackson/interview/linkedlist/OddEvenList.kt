package dev.patrickjackson.interview.linkedlist

/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].

https://leetcode.com/problems/odd-even-linked-list/
 */
fun <T> oddEvenList(head: LinkedList.Node<T>?): LinkedList.Node<T>? {
    head ?: return null
    var odd = head
    var even = head.next
    val evenHead = even
    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next
        even.next = odd?.next
        even = even.next
    }
    odd?.next = evenHead
    return head
}
