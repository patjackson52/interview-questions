package dev.patrickjackson.interview.array

/**
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
https://leetcode.com/problems/subarray-sum-equals-k/

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
fun subarraySumEqualK(nums: IntArray, k: Int): Int {
    var ct = 0
    var sum = 0
    val map = mutableMapOf<Int, Int>(0 to 1)

    nums.forEach {
        sum += it
        if (map.containsKey(sum - k))
            ct += map[sum - k]!!
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return ct
}
