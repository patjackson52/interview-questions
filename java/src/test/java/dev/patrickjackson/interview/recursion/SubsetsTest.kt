package dev.patrickjackson.interview.recursion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SubsetsTest {

    @Test
    fun subsetTest1() = subsetTest1(::subsets)

    @Test
    fun subsetWithBitmaskTest() = subsetTest1(::subsets)

    private fun subsetTest1(func: (IntArray) -> List<List<Int>>) {
        val input = intArrayOf(1, 2, 3)
        val expected = listOf(
            listOf(),
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(1, 2),
            listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3)
        )

        val result = func(input)

        assertEquals(expected.size, result.size)
        assertTrue(expected.containsAll(result))
    }
}
