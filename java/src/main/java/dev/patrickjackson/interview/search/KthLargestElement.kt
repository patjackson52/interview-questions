package dev.patrickjackson.interview.search


/*

# Find the kth largest value in an array


Suppose you have an array of integers 5, 3, 9, 1 (the array is length n) and a value k Find the kth largest value in the array e.g.
* k = 0 => 9
* k = 1 => 5
* k = n-1 => 1

1) sort desc
  O(n log n)
2) linear

fun kthElement(nums: IntArray, k: Int): Int {
    if (k > nums.size - 1) throw IllegalArgumentException("k is too large")
    val sorted = nums.sorted()

    return sorted[sorted.size - 1 - k]
}

Given an array of Integers, find the kth largest number

1) sort and get kth element
2) linear
 */
