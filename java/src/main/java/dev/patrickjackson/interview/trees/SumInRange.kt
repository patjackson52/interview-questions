package dev.patrickjackson.interview.trees

import java.util.ArrayDeque

/*
From FB phone screen 7/2/2020

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

    inRangeHelper(root.left, low, high)
    inRangeHelper(root.right, low, high)
}

 */

/**
 * DFS with recursion
 */
fun rangeSumBST(root: IntTreeNode?, L: Int, R: Int): Int =
    when {
        root == null -> 0
        root.value < L -> rangeSumBST(root.right, L, R)
        root.value > R -> rangeSumBST(root.left, L, R)
        else ->
            root.value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    }

/**
 * DFS with iteration & stack
 */
fun rangeSumBSTIterative(root: IntTreeNode?, L: Int, R: Int): Int {
    val stack = ArrayDeque<IntTreeNode>()
    stack.push(root)
    var sum = 0
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        when {
            node.`val` < L -> if (node.right != null) stack.push(node.right)
            node.`val` > R -> if (node.left != null) stack.push(node.left)
            else -> {
                sum += node.`val`
                if (node.left != null)
                    stack.push(node.left)
                if (node.right != null)
                    stack.push(node.right)
            }
        }
    }
    return sum
}
