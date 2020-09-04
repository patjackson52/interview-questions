package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
    @Test
    fun add1and1() {
        val result = addTwoNumbers(linkedListOf(1).head, linkedListOf(1).head)

        val expected = linkedListOf(2)
        assertEquals(expected, LinkedList(result))
    }

    @Test
    fun add9and5() {
        val result = addTwoNumbers(linkedListOf(9).head, linkedListOf(5).head)

        val expected = linkedListOf(4, 1)
        assertEquals(expected, LinkedList(result))
    }

    /*
    @Test
    fun testMassive() {
        (-1000..1000).forEach { num1 ->
            (-1000..1000).forEach { num2 ->
                test(num1, num2)
            }
        }

    }

     */

    fun test(num1: Int, num2: Int) {
        val sum = num1 + num2
        val ll1 = num1.toLinkedListReversed()
        val ll2 = num2.toLinkedListReversed()
        val expected = sum.toLinkedListReversed()
        val result = LinkedList(addTwoNumbers(ll1.head, ll2.head))
        val list = listOf<Int>()
        assertEquals(expected, result)
    }

    private fun Int.toLinkedListReversed(): LinkedList<Int> =
        linkedListOf(*(toString().reversed().map { it.toInt() }.toTypedArray()))
}
