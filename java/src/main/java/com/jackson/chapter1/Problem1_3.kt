package com.jackson.chapter1

import kotlin.math.max

fun maxSubarraySum(array: IntArray): Int {
    var maxEndingHere = 0
    var maxSoFar = 0

    array.forEach {
        maxEndingHere = max(it, maxEndingHere + it)
        maxSoFar = max(maxEndingHere, maxSoFar)
    }
    return maxSoFar
}