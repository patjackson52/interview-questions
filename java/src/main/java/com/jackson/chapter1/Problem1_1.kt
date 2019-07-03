package com.jackson.chapter1

fun createProductSum(input: IntArray): IntArray {
    val sum = input.reduce { acc, i -> acc * i }
    return input.map { sum / it }.toIntArray()
}