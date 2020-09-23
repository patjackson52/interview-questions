package dev.patrickjackson.interview.linkedlist

fun reverse(linkedList: LinkedList<Int>): LinkedList<Int> {
    linkedList.head ?: return LinkedList()
    var prev: LinkedList.Node<Int>? = null
    var curr: LinkedList.Node<Int>? = linkedList.head

    while (curr != null) {
        val tmp = curr.next
        curr.next = prev
        prev = curr
        curr = tmp
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
