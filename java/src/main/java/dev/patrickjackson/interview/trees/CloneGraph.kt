package dev.patrickjackson.interview.trees

import java.util.LinkedList

/**
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Constraints:

1 <= Node.val <= 100
Node.val is unique for each node.
Number of Nodes will not exceed 100.
There is no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.

 */

class Node(
    val value: Int,
    val neighbors: MutableList<Node?> = mutableListOf()
)

private val cloned = mutableMapOf<Node, Node>()

/*
Complexity Analysis

Time Complexity: O(N)O(N) since we process each node exactly once.
Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
space would also be occupied by the recursion stack since we are adopting a recursive approach here.
The space occupied by the recursion stack would be equal to O(H) where HH is the height of
 the graph. Overall, the space complexity would be O(N).
 */
fun cloneGraphDFS(node: Node?): Node? {
    if (node == null) return null

    if (cloned.contains(node))
        return cloned[node]

    val clone = Node(node.value)
    cloned[node] = clone

    node.neighbors.forEach { neighbor ->
        clone.neighbors.add(cloneGraphDFS(neighbor))
    }

    return clone
}

/**
 * Complexity Analysis

Time Complexity : O(N) since we process each node exactly once.

Space Complexity : O(N). Less than the recursive approach b/c stackframes do not need to be allocated.
This space is occupied by the visited dictionary and in addition to
that, space would also be occupied by the queue since we are adopting the BFS approach here.
The space occupied by the queue would be equal to O(W) where WW is the width of the graph.
Overall, the space complexity would be O(N).
 */
fun cloneGraphBFS(node: Node?): Node? {
    if (node == null) return null

    val visited = mutableMapOf<Node, Node>()

    val queue = LinkedList<Node>()
    queue.add(node)

    visited[node] = Node(node.value)

    while (queue.isNotEmpty()) {
        val curr = queue.remove()

        curr.neighbors.forEach { neighbor ->
            if (!visited.contains(neighbor)) {
                visited[neighbor!!] = Node(neighbor.value)
                queue.add(neighbor)
            }
            visited[curr]!!.neighbors.add(visited[neighbor])
        }
    }

    return visited[node]
}
