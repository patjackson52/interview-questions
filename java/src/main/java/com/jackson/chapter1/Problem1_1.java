package com.jackson.chapter1;

import java.util.Arrays;

/**
 * Given as array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 */
public class Problem1_1 {

    /**
     *
     * @param input array of integers
     * @return array with products of all items except item at i.
     */
    public static int[] createProductArray(int[] input) {
        int[] output = new int[input.length];

        int sum = Arrays.stream(input).reduce((i, last)-> i*last).getAsInt();

        for (int i = 0; i < output.length; i++) {
            output[i] = sum / input[i];
        }
        return output;
    }
}
