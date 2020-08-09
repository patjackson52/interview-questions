package dev.patrickjackson.interview.trees

/*
 Binary Tree Right Side View
 https://leetcode.com/problems/binary-tree-right-side-view/

 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---



   1            <---
 /   \
2     3         <---
 \
  5             <---

  Output: [1, 3, 5]

  Approach:
  1) DFS to right keeping currentLevel and maxLevel. Size of result list can be used for maxLevel
      - recursive
      - iterative w/ stack
  2) BFS
      - 2 queues
      - 1 queue with sentinel
      - calculate level
 */

fun dfsHelper(node: IntTreeNode, level: Int, rightSide: MutableList<Int>) {
    if (level == rightSide.size)
        rightSide.add(node.value)

    if (node.right != null)
        dfsHelper(node, level + 1, rightSide)
    if (node.left != null)
        dfsHelper(node, level, rightSide)
}

fun rightSideViewDfs(node: IntTreeNode?): List<Int> {
    if (node == null) return emptyList()
    val rightSide = mutableListOf<Int>()
    dfsHelper(node, 0, rightSide)
    return rightSide
}

/*

Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you  like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!

# Find the kth largest value in an array


Suppose you have an array of integers 5, 3, 9, 1 (the array is length n) and a value k Find the kth largest value in the array e.g.
* k = 0 => 9
* k = 1 => 5
* k = n-1 => 1

1) sort desc
O(n log n)
2) linear

fun kthElement(nums: IntArray, k: Int): Int {
    if (k > nums.size - 1) throw IllegalArgumentException("k is too large")
    val sorted = nums.sorted()

    return sorted[sorted.size - 1 - k]
}


Sum in binary tree range

// Get sum of all elements in binary search tree which are in range [low, high] inclusive.
//              6
//            /   \
//           4     8
//          / \   / \
//         3   5 7   9
//        /
//       2

3
/ \
2   7
/ \
4   6

3


2, 5, sum = 2 + 3 + 4 + 5

2,3,4,5

23
DFS
1) recursive
2) iteration stack



check if node null return null
check is node low or high
- check left
- check right

sum: 14
root

data class TreeNode(left: TreeNode?, right: TreeNode?, num: Int)

var sum = 0

fun inRange(root: TreeNode?): Int {
    inRangeHelper(root)
    return sum
}

fun inRangeHelper(root: TreeNode?, low: Int, high: Int) {
    if (root == null) return null

    if (root.num in low..high) {
        sum +=root.num
    }

    if (root.left?.num != null && root.left.num >= low) {
        inRangeHelper(root.left, low, high)
    }

    if (root.right?.num != null && root.right.num <= high) {
        inRangeHelper(root.right, low, high)
    }
}

 */