package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementsTest {

    @Test
    fun removeValues() {
        val linkedList = linkedListOf(1, 2, 6, 3, 4, 5, 6)
        val expected = linkedListOf(1, 2, 3, 4, 5)

        val actual = removeElements(linkedList.head, 6)

        assertEquals(expected, LinkedList(actual))
    }

    @Test
    fun removeValuesNotPresent() {
        val linkedList = linkedListOf(1, 2, 6, 3, 4, 5, 6)
        val expected = linkedListOf(1, 2, 6, 3, 4, 5, 6)

        val actual = removeElements(linkedList.head, 9)

        assertEquals(expected, LinkedList(actual))
    }

    @Test
    fun removeLeadingValues() {
        val linkedList = linkedListOf(1, 1, 1, 2, 6, 3, 4, 5, 6)
        val expected = linkedListOf(2, 6, 3, 4, 5, 6)

        val actual = removeElements(linkedList.head, 1)

        assertEquals(expected, LinkedList(actual))
    }
}
