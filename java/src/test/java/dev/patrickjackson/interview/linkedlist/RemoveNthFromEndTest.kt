package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveNthFromEndTest {
    @Test
    fun removeNth() {
        for (length in 0..9) {
            for (n in 0 until length) {
                val linkedList = linkedListOfSize(length)
                var expected: String? = (0 until length).filter { it != length - n }.joinToString()
                if (expected == "") {
                    expected = null
                }
                val actual = removeNthFromEnd(linkedList.head, n)
                assertEquals(expected, actual.toString())
            }
        }
    }
}

/**
 * Create a CSV string of values in list
 */
fun LinkedList.Node<Int>?.toString(): String? {
    val sb = StringBuilder()
    var node = this
    while (node != null) {
        sb.append(node.value)
        node = node.next
        if (node != null)
            sb.append(", ")
    }
    if (sb.isEmpty()) return null
    return sb.toString()
}
