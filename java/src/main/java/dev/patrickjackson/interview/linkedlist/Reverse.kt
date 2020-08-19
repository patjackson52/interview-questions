package dev.patrickjackson.interview.linkedlist

fun reverse(linkedList: LinkedList<Int>): LinkedList<Int> {
    var prev: LinkedList.Node<Int>? = null
    var curr: LinkedList.Node<Int>? = linkedList.head
    var tempNext: LinkedList.Node<Int>? = null

    while (curr != null) {
        tempNext = curr.next
        curr.next = prev
        prev = curr
        curr = tempNext
    }
    return LinkedList(prev)
}
