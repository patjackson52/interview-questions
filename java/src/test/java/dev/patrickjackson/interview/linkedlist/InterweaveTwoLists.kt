package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InterweaveTwoLists {
    @Test
    fun interweaveTwoListsSameSize() {
        val list1 = linkedListOf(1, 2, 3)
        val list2 = linkedListOf(4, 5, 6)

        val result = interweaveTwoLists(list1, list2)

        assertEquals(linkedListOf(1, 4, 2, 5, 3, 6), result)
    }

    @Test
    fun interweaveTwoListsDiffSize() {
        val list1 = linkedListOf(1, 2, 3, 4)
        val list2 = linkedListOf(9, 8, 7, 6, 5)

        val result = interweaveTwoLists(list1, list2)

        assertEquals(linkedListOf(1, 9, 2, 8, 3, 7, 4, 6, 5), result)
    }
}
