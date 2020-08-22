package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class MergeTwoListTest {
    @Test
    fun mergeEmptyLists() {
        val listA = LinkedList<Int>()
        val listB = LinkedList<Int>()

        val result = mergeTwoLists(listA, listB)

        assertNull(result.head)
    }

    @Test
    fun mergeFirstEmpty() {
        val listA = LinkedList<Int>()
        val listB = linkedListOf(1, 2, 3)

        val result = mergeTwoLists(listA, listB)

        assertEquals(listB, result)
    }

    @Test
    fun mergeSecondEmpty() {
        val listA = linkedListOf(1, 2, 3)
        val listB = LinkedList<Int>()

        val result = mergeTwoLists(listA, listB)

        assertEquals(listA, result)
    }

    @Test
    fun mergeInOrder() {
        val listA = linkedListOf(1, 3, 5)
        val listB = linkedListOf(2, 4, 6)

        val result = mergeTwoLists(listA, listB)

        assertEquals(linkedListOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun mergeInOrder2() {
        val listA = linkedListOf(1, 2, 3)
        val listB = linkedListOf(1, 2, 3)

        val result = mergeTwoLists(listA, listB)

        assertEquals(linkedListOf(1, 1, 2, 2, 3, 3), result)
    }
}
