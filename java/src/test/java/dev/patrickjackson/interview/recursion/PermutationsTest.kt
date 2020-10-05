package dev.patrickjackson.interview.recursion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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
        val result = permute(intArrayOf(1, 2, 3))

        assertEquals(expected, result)
    }

    @Test
    fun permutationsRepetitions() {
        val expected = listOf(
            listOf(1, 1, 2),
            listOf(1, 2, 1),
            listOf(2, 1, 1)
        )

        val result = permuteUnique(intArrayOf(1, 1, 2))
        assertEquals(expected, result)
    }

    @Test
    fun listOfListContains() {
        val listOfList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))

        val contains = listOf(1, 2, 3) in listOfList

        assertTrue(contains)
    }
}
