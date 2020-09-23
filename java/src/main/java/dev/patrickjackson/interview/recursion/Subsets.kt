package dev.patrickjackson.interview.recursion

import kotlin.math.pow

/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]

https://leetcode.com/problems/subsets/submissions/
 */

/**
 Cascading solution

Complexity Analysis

Time complexity: O(N×2^N) to generate all subsets and then copy them into output list.

Space complexity: O(N×2^N). This is exactly the number of solutions for subsets multiplied
by the number N of elements to keep for each subset.

For a given number, it could be present or absent (i.e. binary choice) in a subset solution.
As as result, for N numbers, we would have in total 2^N choices (solutions).
 */
fun subsets(nums: IntArray): List<List<Int>> {
    val output = mutableListOf(listOf<Int>())

    nums.forEach { num ->
        val newSubset = mutableListOf<List<Int>>()
        output.forEach { curr ->
            newSubset.add(curr.plus(num))
        }
        output.addAll(newSubset)
    }
    return output
}

fun subsetsWithBitmask(nums: IntArray): MutableList<List<Int>> {
    val output = mutableListOf<List<Int>>()
    val n = nums.size

    (2.toDouble().pow(n).toInt() until 2.toDouble().pow((n + 1)).toInt()).forEach { i ->
        val bitmask = Integer.toBinaryString(i).substring(1)

        val curr = mutableListOf<Int>()
        (0 until n).forEach { j ->
            if (bitmask[j] == '1')
                curr.add(nums[j])
        }
        output.add(curr)
    }
    return output
}
