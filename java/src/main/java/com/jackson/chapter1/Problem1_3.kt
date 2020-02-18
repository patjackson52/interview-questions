package com.jackson.chapter1

import kotlin.math.max

/**
 * Kadane's solution - computes in one pass
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
fun maxSubarraySum(array: IntArray): Int {
    var maxEndingHere = 0
    var maxSoFar = 0

    array.forEach {
        maxEndingHere = max(it, maxEndingHere + it)
        maxSoFar = max(maxEndingHere, maxSoFar)
    }
    return maxSoFar
}


/**
 * Bruteforce solution that uses nested loops
 * Time complexity: O(n²)
 * Space complexity: O(1)
 */
fun maxSubarraySumBruteForce(array: IntArray): Int {
    var maxSum = Integer.MIN_VALUE
    for (i in array.indices) {
        var subarraySum = 0
        for (k in i until array.size) {
            subarraySum += array[k]
        }
        if (subarraySum > maxSum) {
            maxSum = subarraySum
        }
    }
    return maxSum
}
