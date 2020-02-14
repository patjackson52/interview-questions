package com.jackson.chapter1


import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Problem1_4Test {

    @Test
    fun `Find num smaller to right - java (1)`() =
            test1(Problem1_4::findNumSmallerToRight)

    @Test
    fun `Find num smaller to right - kotlin (1)`() =
            test1(::findNumSmallestToRight)
    @Test
    fun `Find num smaller to right - java (2)`() =
            test2(Problem1_4::findNumSmallerToRight)

    @Test
    fun `Find num smaller to right - kotlin (2)`() =
            test2(::findNumSmallestToRight)

    private fun test1(f: ((IntArray) -> IntArray)) {
        val input = intArrayOf(3, 4, 9, 6, 1)
        val correctMaxSum = intArrayOf(1, 1, 2, 1, 0)
        val result = f(input)
        assertArrayEquals(correctMaxSum, result)
    }

    private fun test2(f: ((IntArray) -> IntArray)) {
        val input = intArrayOf(3, 9, 0, 1, -9, -3, 7)
        val correctArray = intArrayOf(4, 5, 2, 2, 0, 0, 0)
        val result = f(input)
        assertArrayEquals(correctArray, result)
    }
}
