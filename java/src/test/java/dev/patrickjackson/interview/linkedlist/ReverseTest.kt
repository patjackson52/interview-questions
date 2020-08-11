package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseTest {
    @Test
    fun reverseLinkedList() {
        val linkedList = linkedListOfSize(5)
        val reversedList = linkedListOf(4, 3, 2, 1, 0)

        assertEquals(reversedList, reverse(linkedList))
    }

    @Test
    fun reverseEmptyList() {
        val linkedList = LinkedList<Int>()

        assertEquals(null, reverse(linkedList).head)
    }
}
