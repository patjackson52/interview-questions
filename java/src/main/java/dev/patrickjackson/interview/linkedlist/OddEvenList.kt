package dev.patrickjackson.interview.linkedlist

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
