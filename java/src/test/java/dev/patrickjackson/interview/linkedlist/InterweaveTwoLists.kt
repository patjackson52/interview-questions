package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InterweaveTwoLists {
    @Test
    fun interweaveTwoListsSameSize() {
        val list1 = linkedListOf(1, 2, 3)
        val list2 = linkedListOf(4, 5, 6)

        val result = interweaveTwoLists(list1, list2)

        assertEquals(linkedListOf(1,4,2,5,3,6), result)
    }
}