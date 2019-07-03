package com.jackson.chapter1


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertArrayEquals

class Problem1_1Test {

    @Test
    fun `Get product of all other elements - java (1)`() {
        test1(Problem1_1::createProductArray)
    }

    @Test
    fun `Get product of all other elements - kotlin (1)`() {
        test1(::createProductSum)
    }
    @Test
    fun `Get product of all other elements - java (2)`() {
        test2(Problem1_1::createProductArray)
    }

    @Test
    fun `Get product of all other elements - kotlin (2)`() {
        test2(::createProductSum)
    }

    private fun test1(f: ((IntArray) -> IntArray)) {
        val input = intArrayOf(1, 2, 3)
        val correctProductArray = intArrayOf(6, 3, 2)
        val result = f(input)
        assertArrayEquals(correctProductArray, result)
    }

    private fun test2(f: ((IntArray) -> IntArray)) {
        val input = intArrayOf(1, 2, 3, 4, 5)
        val correctProductArray = intArrayOf(120, 60, 40, 30, 24)
        val result = f(input)
        assertArrayEquals(correctProductArray, result)
    }
}
