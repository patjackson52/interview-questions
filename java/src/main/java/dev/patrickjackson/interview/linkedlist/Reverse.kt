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

fun <T> reverseListWith2Ptr(head: LinkedList.Node<T>?): LinkedList.Node<T>? {
    head ?: return head
    var currentHead = head
    while (head.next != null) {
        val p = head.next
        head.next = p?.next
        p?.next = currentHead
        currentHead = p
    }
    return currentHead
}
