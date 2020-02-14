package com.jackson.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1_4 {

    /**
     * Finds the num of smaller elements to the right in the array.
     * Time complexity: O(N logN) - traverse array and maintain sorted list of previous elements
     * Space complexity: O(N) - array of size N needed to hold sorted array.
     */
    public static int[] findNumSmallerToRight(int[] array) {
        int[] results = new int[array.length];
        List<Integer> seen = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            int insertPos = Collections.binarySearch(seen, array[i]);
            if (insertPos < 0) {
                insertPos = -insertPos - 1;
            }
            seen.add(insertPos, array[i]);
            results[i] = insertPos;
        }

        return results;
    }
}
