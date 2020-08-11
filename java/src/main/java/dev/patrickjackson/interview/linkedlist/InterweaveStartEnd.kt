package dev.patrickjackson.interview.linkedlist

/**
 * Interweave a linked list by alternating front and rear elements.
 * Ex.  1->2->3->4->5->null
 *     1->5->2->4->3->null
 * FB onsite question July 2020
 *
 * 1. make 2 lists
 * 2. reverse 2nd list
 * 3. interleave
 */
fun interweaveStartEnd(linkedList: LinkedList<Int>): LinkedList<Int> {
    val secondHalf = findNodeBeforeMiddle(linkedList)
    val secondHead = secondHalf?.next
    secondHalf?.next = null
    val reversed = reverse(LinkedList(secondHead))
    val result = interweaveTwoLists(linkedList, reversed)
    return result
}
