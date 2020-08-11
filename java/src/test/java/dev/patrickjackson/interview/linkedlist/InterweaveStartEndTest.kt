package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InterweaveStartEndTest {

    @Test
    fun interweaveStartEndTest() {
        val list = linkedListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val expected = linkedListOf(1, 9, 2, 8, 3, 7, 4, 6, 5)

        assertEquals(expected, interweaveStartEnd(list))
    }
}
