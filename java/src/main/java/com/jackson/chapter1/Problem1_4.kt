package com.jackson.chapter1

/**
 * Finds the num of smaller elements to the right in the array.
 * Time complexity: O(N logN) - traverse array and maintain sorted list of previous elements
 * Space complexity: O(N) - array of size N needed to hold sorted array.
 */
fun findNumSmallestToRight(array: IntArray): IntArray {
    val results = IntArray(array.size)
    val seen = mutableListOf<Int>()

    for ( i in array.size - 1 downTo 0) {
        var insertPos = seen.binarySearch(array[i])
        if (insertPos < 0) {
            insertPos = -insertPos -1
        }
        seen.add(insertPos, array[i])
        results[i] = insertPos
    }

    return results
}