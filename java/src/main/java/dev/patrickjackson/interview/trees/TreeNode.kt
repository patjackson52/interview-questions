package dev.patrickjackson.interview.trees

data class TreeNode<T>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
    // optional next right node
    var next: TreeNode<T>? = null
) {
    // for easy copy/paste from leetcode
    val `val` get() = value
}
typealias IntTreeNode = TreeNode<Int>
