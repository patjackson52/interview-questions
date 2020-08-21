package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsPalindromeTest {
    @Test
    fun detectPalindrome() {
        val linkedList = "racecar".toLinkedList()

        assertTrue(isPalindrome(linkedList.head))
    }

    @Test
    fun detectNotAPalindrome() {
        val linkedList = "banana".toLinkedList()

        assertFalse(isPalindrome(linkedList.head))
    }

    @Test
    fun detectEmptyListAsPalindrome() {
        val linkedList = "".toLinkedList()

        assertTrue(isPalindrome(linkedList.head))
    }
}

class LinkedListToStringTest {
    @Test
    fun testToString() {
        val result = "abc".toLinkedList()
        val expected = linkedListOf('a', 'b', 'c')

        assertEquals(expected, result)
    }

    @Test
    fun testEmptyString() {
        val result = "".toLinkedList()
        val expected = LinkedList<Char>()

        assertEquals(expected, result)
    }
}

fun String.toLinkedList(): LinkedList<Char> {
    val result = LinkedList<Char>()
    if (isEmpty()) return result
    var curr: LinkedList.Node<Char>? = null
    var prev: LinkedList.Node<Char>? = null
    forEach {
        curr = LinkedList.Node(it)
        if (result.head == null)
            result.head = curr
        prev?.next = curr
        prev = curr
    }
    return result
}
