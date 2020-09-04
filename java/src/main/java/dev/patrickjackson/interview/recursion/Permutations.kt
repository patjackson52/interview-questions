package dev.patrickjackson.interview.recursion

import java.util.Collections.swap

/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

https://leetcode.com/problems/permutations/
 */
fun permute(nums: IntArray): List<List<Int>> {
    val output = mutableListOf<List<Int>>()
    backtrack(nums.size, nums.toList(), output, 0)
    return output
}

fun backtrack(
    n: Int,
    nums: List<Int>,
    output: MutableList<List<Int>>,
    first: Int
) {
    if (first == n)
        output.add(nums.toList())
    (first until n).forEach { i ->
        swap(nums, first, i)
        backtrack(n, nums, output, first + 1)
        swap(nums, first, i)
    }
}
