package dev.patrickjackson.interview.linkedlist

/**
 * "interweave" or "merge" two lists.
 * Ex.
 *   list1: 1->2->3->null
 *   list2: 4->5->6->null
 *   result: 1->4->2->5->3->6->null
 */
fun interweaveTwoLists(list1: LinkedList<Int>, list2: LinkedList<Int>): LinkedList<Int> {
    list1.head ?: return list2
    list2.head ?: return list1
    var curr1 = list1.head?.next
    var curr2 = list2.head
    val head = list1.head
    var tail = list1.head

    while (curr1 != null && curr2 != null) {
        tail?.next = curr2
        curr2 = curr2.next
        tail = tail?.next
        tail?.next = curr1
        curr1 = curr1.next
        tail = tail?.next
    }
    tail?.next = curr2 ?: curr1
    return LinkedList(head)
}
