package dev.patrickjackson.interview.search

/*
Given an array of strings products and a string searchWord. We want to design a system that suggests
at most three product names from products after each character of searchWord is typed. Suggested
products should have common prefix with the searchWord. If there are more than three products with
a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]


Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 */

/*
 Clarifying Questions:

 Is the product array sorted?
   - no
 What is the character set?
   - if all lowercase english letters we may be able to optimize
 Is this function going to be used many times on the same product array with different searchTerms?

 What are the expected sizes for the inputs?

 Possible approaches:
    1) Trie (prefix tree)
        - build trie
            - O(n) time where n is number of all chars in product list
            - O(w) space where w is number of words
        - search & return up to 3 products
            - O(k) time where k is length of searchTerm
    2) Binary Search
        - sort product array
            - O(n log n) time (mergesort by default on JVM)
            - O(log n) space
        - implement custom binary search on the searchTerm
            - O(log n)
        - if term with prefix or term found, check the next 2 times if they contain prefix as well
              and return up to 3 results

    Trade-offs:
        Solution #1 is more complicated and requires more code, however the trie offers a faster
        search time.  If this is a search to be performed many many times then this may be worth
        the optimization.

        Solution #2 is more simple and less code.  It may use less memory if the array is sorted
        in place.  Search is a larger time complexity, however O(log n) is probably acceptable unless
        the product list is extremely large or we need to scale this to lots of queries.

 */