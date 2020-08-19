package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class LinkedListCycleKtTest {

    @Test
    fun doesHaveCycle() {
        val linkedList = linkedListWithCycle(2, 1, 2, 3, 4)

        assertTrue(hasCycle(linkedList))
    }

    @Test
    fun doesNotHaveCycle() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5)

        assertFalse(hasCycle(linkedList))
    }

    @Test
    fun handlesEmptyLinkedList() {
        val linkedList = LinkedList<Int>()

        assertFalse(hasCycle(linkedList))
    }

    @Test
    fun handles1NodeLinkToSelf() {
        val linkedList = linkedListWithCycle(0, 1)

        assertTrue(hasCycle(linkedList))
    }

    @Test
    fun handlesListSize2() {
        val linkedList = linkedListWithCycle(1, 1, 2)

        assertTrue(hasCycle(linkedList))
    }
}

/**
 * Creates a linked list with a cycle.
 * @param cyclePos pos of node that the tail returns to.
 */
fun <T> linkedListWithCycle(cyclePos: Int, vararg values: T): LinkedList<T> {
    val result = LinkedList<T>()
    var curr: LinkedList.Node<T>? = null
    var cycleNode: LinkedList.Node<T>? = null
    for (i in values.indices) {
        if (i == 0) {
            result.head = LinkedList.Node(values[i])
            curr = result.head
        } else {
            curr?.next = LinkedList.Node(values[i])
        }
        if (i == cyclePos)
            cycleNode = curr
    }
    curr?.next = cycleNode
    return result
}
