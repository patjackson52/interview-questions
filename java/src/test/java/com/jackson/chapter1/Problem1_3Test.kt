package com.jackson.chapter1


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Problem1_3Test {

    @Test
    fun `Get max subarray sum - java (1)`() {
        test1(Problem1_3::maxSubarraySum)
    }

    @Test
    fun `Get max subarray sum when all negative - java (2)`() {
        test2(Problem1_3::maxSubarraySum)
    }

    @Test
    fun `Get max subarray sum - kotlin (1)`() {
        test1(::maxSubarraySum)
    }

    @Test
    fun `Get max subarray sum when all negative - kotlin (2)`() {
        test2(::maxSubarraySum)
    }

    private fun test1(f: ((IntArray) -> Int)) {
        val input = intArrayOf(34, -50, 42, 14, -5, 86)
        val correctMaxSum = 137
        val result = f(input)
        assertEquals(correctMaxSum, result)
    }

    private fun test2(f: ((IntArray) -> Int)) {
        val input = intArrayOf(-1, -6, -3, -10, -5)
        val correctMaxSum = 0
        val result = f(input)
        assertEquals(correctMaxSum, result)
    }
}
