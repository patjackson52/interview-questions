package dev.patrickjackson.interview.trees

import java.util.LinkedList

/**
Serialization is the process of converting a data structure or object into a sequence of bits so
that it can be stored in a file or memory buffer, or transmitted across a network connection link
to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

 1
 / \
 2   3
 / \
4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not
necessarily need to follow this format, so please be creative and come up with different approaches
yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and
deserialize algorithms should be stateless.

https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/
 */

class IntTreeSerializer {

    fun serialize(root: IntTreeNode?): String =
        serializeHelper(root, "")

    fun deserialize(data: String): IntTreeNode? {
        val nodeArray = data.split(",")
        val nodeList: MutableList<String> = LinkedList(nodeArray)
        return deserializeHelper(nodeList)
    }

    private fun serializeHelper(root: IntTreeNode?, str: String): String =
        if (root == null) {
            str + "null,"
        } else {
            var result = str + root.`val` + ","
            result = serializeHelper(root.left, result)
            serializeHelper(root.right, result)
        }

    private fun deserializeHelper(values: MutableList<String>): IntTreeNode? {
        val nodeVal = values[0]
        values.removeAt(0)
        if (nodeVal == "null") return null

        val node = TreeNode(nodeVal.toInt())
        node.left = deserializeHelper(values)
        node.right = deserializeHelper(values)
        return node
    }
}
