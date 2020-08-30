package dev.patrickjackson.interview.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraySumEqualsKTest {
    @Test
    fun emptyArray() {
        val array = intArrayOf()

        val result = subarraySumEqualK(array, 2)

        assertEquals(0, result)
    }

    @Test
    fun array1() {
        val array = intArrayOf(1, 1, 1)

        val result = subarraySumEqualK(array, 2)

        assertEquals(2, result)
    }

    @Test
    fun array2() {
        val array = intArrayOf(1, 1, 1, 1, 1, 1)

        val result = subarraySumEqualK(array, 2)

        assertEquals(5, result)
    }

    @Test
    fun array3() {
        val array = intArrayOf(1, 2, 1, 6, -1, 3)

        val result = subarraySumEqualK(array, 2)

        assertEquals(2, result)
    }

    @Test
    fun arrayWithNegatives() {
        val array = intArrayOf(1, -1, 1, 1, -1, 1)

        val result = subarraySumEqualK(array, 2)

        assertEquals(4, result)
    }

    @Test
    fun arrayWithNegatives2() {
        val array = intArrayOf(1, -1, 2, -2, 0, 1, 1, -1, -2, 2, 1, 3)

        val result = subarraySumEqualK(array, 2)

        assertEquals(11, result)
    }
}
