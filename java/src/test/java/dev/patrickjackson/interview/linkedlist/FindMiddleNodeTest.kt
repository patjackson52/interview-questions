package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class FindMiddleNodeTest {
    @Test
    fun findMiddleWithOddNumber() {
        val linkedList = linkedListOfSize(9)

        val middle = findMiddleNode(linkedList)

        assertSame(linkedList.get(4), middle)
    }

    @Test
    fun findMiddleWith2EvenNumber() {
        val linkedList = linkedListOfSize(10)

        val middle = findMiddleNode(linkedList)

        assertSame(linkedList.get(5), middle)
    }

    @Test
    fun findMiddleWith1Node() {
        val linkedList = linkedListOfSize(1)

        val middle = findMiddleNode(linkedList)

        assertSame(linkedList.head, middle)
    }

    @Test
    fun findMiddleWithEmpty() {
        val linkedList = LinkedList<Int>()

        val middle = findMiddleNode(linkedList)

        assertNull(middle)
    }
}
