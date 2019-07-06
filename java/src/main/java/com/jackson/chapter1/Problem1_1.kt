package com.jackson.chapter1

fun createProductSum(input: IntArray): IntArray {
    val sum = input.reduce { acc, i -> acc * i }
    return input.map { sum / it }.toIntArray()
}

fun createProductSumWithoutDiv(input: IntArray): IntArray {
    val leftProduct = IntArray(input.size)
    val rightProduct = IntArray(input.size)

    for (i in (0 until input.size)) {
        if (i == 0) {
            leftProduct[i] = 1
        } else {
            leftProduct[i] = leftProduct[i - 1] * input[i - 1]
        }
    }

    for (i in input.size - 1 downTo 0) {
       if (i == input.size - 1) {
           rightProduct[i] = 1
       } else {
           rightProduct[i] = rightProduct[i + 1] * input[i + 1]
       }
    }

    return (0 until input.size).map { leftProduct[it] * rightProduct[it] }.toIntArray()
}