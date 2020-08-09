package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LinkedListNodeTests {
    @Test
    fun getAtIndex() {
        val head = LinkedListNode(1)
        head.next = LinkedListNode(2)

        val result = head.get(1)

        assertEquals(2, result?.value)
    }
}