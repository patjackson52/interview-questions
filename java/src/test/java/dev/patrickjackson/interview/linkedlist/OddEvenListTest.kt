package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class OddEvenListTest {
    @Test
    fun handleNull() {
        assertNull(oddEvenList<Int>(null))
    }

    @Test
    fun handleOneItem() {
        val linkedList = linkedListOf(1)
        val expected = linkedListOf(1)
        assertEquals(expected, LinkedList(oddEvenList(linkedList.head)))
    }

    @Test
    fun makeOddEvenList() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5)
        val expected = linkedListOf(1, 3, 5, 2, 4)
        val actual = oddEvenList(linkedList.head)

        assertEquals(expected, LinkedList(actual))
    }

    @Test
    fun makeOddEvenListEvenSize() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5, 6)
        val expected = linkedListOf(1, 3, 5, 2, 4, 6)
        val actual = oddEvenList(linkedList.head)

        assertEquals(expected, LinkedList(actual))
    }
}
