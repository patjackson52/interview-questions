package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import kotlin.math.min

class IntersectionTwoListsTest {

    @Test
    fun returnNullNoIntersectionDiffLength() {
        val listA = linkedListOfSize(10)
        val listB = linkedListOfSize(9)

        assertNull(getIntersectionNode(listA, listB))
    }

    @Test
    fun returnNullNoIntersectionSameLength() {
        val listA = linkedListOfSize(10)
        val listB = linkedListOfSize(10)

        assertNull(getIntersectionNode(listA, listB))
    }

    @Test
    fun returnIntersectionNode() {
        for (lengthA in 2..10)
            for (lengthB in 2..10)
                for (sharedLength in 1..min(lengthA - 1, lengthB - 1))
                    testIntersection(lengthA, lengthB, sharedLength)
    }

    fun testIntersection(
        lengthA: Int,
        lengthB: Int,
        sharedListLength: Int
    ) {
        val (listA, listB) = intersectingLists(lengthA, lengthB, sharedListLength)
        val expected = listA.get(lengthA - sharedListLength)
        val actual = getIntersectionNode(listA, listB)
        assertSame(expected, actual)
    }
    /**
     * Create intersecting linked lists.
     * Values are not relevant
     */
    fun intersectingLists(
        lengthA: Int,
        lengthB: Int,
        sharedListLength: Int
    ): Pair<LinkedList<Int>, LinkedList<Int>> {
        val sharedList = linkedListOfSize(sharedListLength)
        val listA = linkedListOfSize(lengthA - sharedListLength)
        listA.get(lengthA - sharedListLength - 1)?.next = sharedList.head

        val listB = linkedListOfSize(lengthB - sharedListLength)
        listB.get(lengthB - sharedListLength - 1)?.next = sharedList.head
        return Pair(listA, listB)
    }
}
