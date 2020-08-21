package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class DoublyLinkedListTests {

    @Test
    fun getAtIndex() {
        val linkedList = doublyLinkedListOfSize(2)

        val result = linkedList.get(1)

        assertEquals(1, result?.value)
    }

    @Test
    fun addToHead() {
        val linkedList = doublyLinkedListOfSize(2)

        linkedList.addAtHead(100)

        assertEquals(100, linkedList.head?.value)
    }

    @Test
    fun addAtIndex() {
        val linkedList = doublyLinkedListOfSize(10)

        linkedList.addAtIndex(5, 100)

        assertEquals(100, linkedList.get(5)?.value)
    }

    @Test
    fun addAtIndexEmptyList() {
        val linkedList = DoublyLinkedList<Int>()

        linkedList.addAtIndex(0, 100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun addAtEndOfList() {
        val linkedList = doublyLinkedListOfSize(4)

        linkedList.addAtIndex(4, 100)

        assertEquals(100, linkedList.get(4)?.value)
    }

    @Test
    fun addAtTail() {
        val linkedList = doublyLinkedListOfSize(3)

        linkedList.addAtTail(100)

        assertEquals(100, linkedList.get(3)?.value)
    }

    @Test
    fun addAtTailEmptyList() {
        val linkedList = DoublyLinkedList<Int>()

        linkedList.addAtTail(100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun addAtIndexInvalidIgnored() {
        val linkedList = DoublyLinkedList<Int>()

        linkedList.addAtIndex(0, 100)

        linkedList.get(0)
    }

    @Test
    fun addAtIndex0() {
        val linkedList = doublyLinkedListOf(1, 2, 3)

        linkedList.addAtIndex(0, 100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun deleteAtIndex() {
        val linkedList = doublyLinkedListOfSize(10)

        linkedList.deleteAtIndex(4)

        assertEquals(5, linkedList.get(4)?.value)
    }

    @Test
    fun deleteFirstNode() {
        val linkedList = doublyLinkedListOfSize(10)

        linkedList.deleteAtIndex(0)

        assertEquals(1, linkedList.get(0)?.value)
    }

    @Test
    fun linkedListOfCreatesList() {
        val linkedList = doublyLinkedListOf(1, 2, 3, 4)

        var curr = linkedList.head
        (1..4).forEach {
            assertEquals(it, curr?.value)
            curr = curr?.next
        }
    }

    @Test
    fun linkedListOfCreatesListOf1() {
        val linkedList = doublyLinkedListOf(1)

        assertEquals(1, linkedList.head?.value)
    }

    @Test
    fun isEqual() {
        val linkedList1 = doublyLinkedListOfSize(4)
        val linkedList2 = doublyLinkedListOfSize(4)

        assertEquals(linkedList1, linkedList2)
    }

    @Test
    fun isNotEqual() {
        val linkedList1 = doublyLinkedListOfSize(3)
        val linkedList2 = doublyLinkedListOfSize(4)

        assertNotEquals(linkedList1, linkedList2)
    }

    @Test
    fun isEqualEmptyList() {
        val linkedList1 = DoublyLinkedList<Int>()
        val linkedList2 = DoublyLinkedList<Int>()

        assertEquals(linkedList1, linkedList2)
    }
}

fun doublyLinkedListOfSize(size: Int): DoublyLinkedList<Int> {
    if (size == 0) return DoublyLinkedList()
    val head = DoublyLinkedList.Node(0)
    var curr: DoublyLinkedList.Node<Int>? = head
    (1 until size).forEach {
        curr?.next = DoublyLinkedList.Node(it, prev = curr)
        curr = curr?.next
    }
    return DoublyLinkedList(head)
}

fun <T> doublyLinkedListOf(vararg values: T): DoublyLinkedList<T> {
    val head = DoublyLinkedList.Node(values[0])
    var curr: DoublyLinkedList.Node<T>? = head
    (1 until values.size).forEach {
        curr?.next = DoublyLinkedList.Node(values[it], prev = curr)
        curr = curr?.next
    }
    return DoublyLinkedList(head)
}
