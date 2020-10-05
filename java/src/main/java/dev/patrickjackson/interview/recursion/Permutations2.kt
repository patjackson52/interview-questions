package dev.patrickjackson.interview.recursion

/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
[1,1,2],
[1,2,1],
[2,1,1]
]
 */
import java.util.Collections.swap

fun permuteUnique(nums: IntArray): List<List<Int>> {
    val output = mutableListOf<List<Int>>()
    backtrackUnique(nums.toMutableList(), output, 0)
    return output
}

fun backtrackUnique(
    nums: MutableList<Int>,
    output: MutableList<List<Int>>,
    first: Int
) {
    if (first == nums.size)
        output.add(nums.toList())

    val set = mutableSetOf<Int>()
    (first until nums.size).forEach { i ->
        if (set.add(nums[i])) {
            swap(nums, first, i)
            backtrackUnique(nums, output, first + 1)
            swap(nums, first, i)
        }
    }
}
