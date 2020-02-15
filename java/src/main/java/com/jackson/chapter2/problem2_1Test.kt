package com.jackson.chapter2

/**
 * Finds starting indices of all anagrams of w in s.
 * Time complexity: O(n) - completes in one pass using a 'window' with freq map of chars.
 * Space complexity: O(s) - freq map could potential contain s entries (all unique chars).
 */
fun findAnagramIndices(s: String, w: String): List<Int> {
    val results = mutableListOf<Int>()
    val freq = mutableMapOf<Char, Int>()

    for (ch in w) {
        freq.increment(ch)
    }

    for (i in w.indices) {
        freq.decrement(s[i])
        delIfZero(freq, s[i])
    }

    if (freq.isEmpty()) {
        results.add(0)
    }

    for (i in w.length until s.length) {
        val startCh = s[i - w.length]
        val endCh = s[i]
        freq.increment(startCh)
        delIfZero(freq, startCh)

        freq.decrement(endCh)
        delIfZero(freq, endCh)

        if (freq.isEmpty()) {
            results.add((i - w.length) + 1)
        }
    }
    return results
}

fun delIfZero(map: MutableMap<Char, Int>, ch: Char) {
    if (map[ch] == 0) {
        map.remove(ch)
    }
}

fun MutableMap<Char, Int>.increment(ch: Char) {
     if (!containsKey(ch)) {
        put(ch, 1)
     } else {
         put(ch, get(ch)!! + 1)
     }
}

fun MutableMap<Char, Int>.decrement(ch: Char) {
    if (!containsKey(ch)) {
        put(ch, -1)
    } else {
        put(ch, get(ch)!! - 1)
    }
}