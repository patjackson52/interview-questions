package com.jackson.chapter1;

public class Problem1_3 {

    /**
     * Kadane's solution - computes in one pass
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int maxSubarraySum(int[] array) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        for (int i = 0; i < array.length; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
