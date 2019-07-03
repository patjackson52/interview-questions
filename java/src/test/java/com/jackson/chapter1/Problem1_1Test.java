package com.jackson.chapter1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Problem1_1Test {

    @Test
    public void arrayProduct() {
        int[] input = new int[] {1,2,3};
        int[] correctProductArray = new int[] {6,3,2};
        assertArrayEquals(correctProductArray, Problem1_1.createProductArray(input));
    }
    @Test
    public void arrayProduct2() {
        int[] input = new int[] {1,2,3,4,5};
        int[] correctProductArray = new int[] {120,60,40,30,24};
        assertArrayEquals(correctProductArray, Problem1_1.createProductArray(input));
    }
}
