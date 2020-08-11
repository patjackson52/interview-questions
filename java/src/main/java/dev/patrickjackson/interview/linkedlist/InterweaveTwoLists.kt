package dev.patrickjackson.interview.linkedlist

/**
 * "Merge" or "interweave" two lists.
 * Ex.
 *   list1: 1->2->3->null
 *   list2: 4->5->6->null
 *   result: 1->4->2->5->3->6->null
 */
fun interweaveTwoLists(list1: LinkedList<Int>, list2: LinkedList<Int>): LinkedList<Int> {
    var curr1 = list1.head
    var curr2 = list2.head
    var next1: LinkedList.LinkedListNode<Int>? = null
    var next2: LinkedList.LinkedListNode<Int>? = null
    val head = list1.head

    while (curr1 != null && curr2 != null) {
        next1 = curr1.next
        next2 = curr2.next

        curr1.next = curr2
        curr2.next = next1

        curr1 = next1
        curr2 = next2
    }
    return LinkedList(head)
}