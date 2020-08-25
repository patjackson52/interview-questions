package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateRightTest {
    @Test
    fun rotateList1() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5)

        val result = rotateRight(linkedList.head, 3)

        assertEquals(linkedListOf(3, 4, 5, 1, 2), LinkedList(result))
    }

    @Test
    fun rotateRightKGreaterThanSize() {
        val linkedList = linkedListOf(1, 2, 3, 4, 5)

        val result = rotateRight(linkedList.head, 10)

        assertEquals(linkedListOf(1, 2, 3, 4, 5), LinkedList(result))
    }

    @Test
    fun handleEmpty() {
        val linkedList = LinkedList<Int>()

        val result = rotateRight(linkedList.head, 10)

        assertEquals(null, result)
    }

    @Test
    fun handleSingleItem() {
        val linkedList = linkedListOf(1)

        val result = rotateRight(linkedList.head, 10)

        assertEquals(linkedListOf(1), LinkedList(result))
    }
}
