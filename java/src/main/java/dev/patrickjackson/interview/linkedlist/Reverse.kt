package dev.patrickjackson.interview.linkedlist

fun reverse(linkedList: LinkedList<Int>): LinkedList<Int> {
    var prev: LinkedList.LinkedListNode<Int>? = null
    var curr: LinkedList.LinkedListNode<Int>? = linkedList.head
    var tempNext: LinkedList.LinkedListNode<Int>? = null

    while (curr != null) {
        tempNext = curr.next
        curr.next = prev
        prev = curr
        curr = tempNext
    }
    return LinkedList(prev)
}