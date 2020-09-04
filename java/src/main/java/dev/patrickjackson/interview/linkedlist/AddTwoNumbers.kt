package dev.patrickjackson.interview.linkedlist

fun addTwoNumbers(l1: LinkedList.Node<Int>?, l2: LinkedList.Node<Int>?): LinkedList.Node<Int>? =
    addTwoNumbersHelper(l1, l2, 0)

private fun addTwoNumbersHelper(
    l1: LinkedList.Node<Int>?,
    l2: LinkedList.Node<Int>?,
    carryOver: Int
): LinkedList.Node<Int>? {
    if (l1 == null && l2 == null) {
        return if (carryOver == 0)
            null
        else LinkedList.Node(carryOver)
    }
    val sum = (l1?.value ?: 0) + (l2?.value ?: 0)
    val result = LinkedList.Node(sum % 10)
    result.next = addTwoNumbersHelper(l1?.next, l2?.next, sum / 10)
    return result
}
