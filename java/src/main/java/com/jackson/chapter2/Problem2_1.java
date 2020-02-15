package com.jackson.chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem2_1 {
    public static List<Integer> findAnagramIndices(String s, String w) {
        List<Integer> results = new ArrayList<>();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < w.length(); i++) {
            increment(freq, w.charAt(i));
        }

        for (int i = 0; i < w.length(); i++) {
            decrement(freq, s.charAt(i));
            delIfZero(freq, s.charAt(i));
        }

        if (freq.isEmpty()) {
            results.add(0);
        }

        for (int i = w.length(); i < s.length(); i++) {
            Character startCh = s.charAt(i - w.length());
            Character endCh = s.charAt(i);
            increment(freq, startCh);
            delIfZero(freq, startCh);

            decrement(freq, endCh);
            delIfZero(freq, endCh);

            if (freq.isEmpty()) {
                results.add((i - w.length()) + 1);
            }
        }
        return results;
    }

    private static void delIfZero(HashMap<Character, Integer> map, Character ch) {
        if (map.get(ch) == 0) {
            map.remove(ch);
        }
    }

    private static void increment(HashMap<Character, Integer> map, Character ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, 1);
        } else {
            map.put(ch, map.get(ch) + 1);
        }
    }

    private static void decrement(HashMap<Character, Integer> map, Character ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, map.get(ch) - 1);
        }
    }
}


