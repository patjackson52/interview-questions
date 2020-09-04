package dev.patrickjackson.interview.recursion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PermutationsTest {
    @Test
    fun permutations() {
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 2, 1),
            listOf(3, 1, 2)
        )

        assertEquals(expected, permute(intArrayOf(1, 2, 3)))
    }
}
