package dev.patrickjackson.interview.trees

import java.util.*


/**
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
 */

/**
 * Level by level traversal using a queue.
 * O(N) time complexity
 * O(N) space complexity
 *
 * Better solution exists that uses O(1) space complexity
 */
fun connect(root: IntTreeNode?): IntTreeNode? {
    if (root == null) return null
    val queue = LinkedList<IntTreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            if (i < size - 1)
                node.next = queue.peek()
            if (node.left != null)
                queue.add(node.left!!)
            if (node.right != null)
                queue.add(node.right!!)

        }
    }
    return root
}
