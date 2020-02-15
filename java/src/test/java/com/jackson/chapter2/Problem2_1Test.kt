package com.jackson.chapter2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Problem2_1Test {

    @Test
    fun `Find anagram indices - kotlin (1)`() =
            test1(::findAnagramIndices)

    @Test
    fun `Find anagram indices - java (1)`() =
            test1(Problem2_1::findAnagramIndices)

    private fun test1(f: ((String, String) -> List<Int>)) {
        val inputString = "abxaba"
        val inputWord = "ab"
        val correctIndices = listOf(0, 3, 4)
        val result = f(inputString, inputWord)
        assertEquals(correctIndices, result)
    }
}