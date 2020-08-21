package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class LinkedListTests {

    @Test
    fun getAtIndex() {
        val linkedList = linkedListOfSize(2)

        val result = linkedList.get(1)

        assertEquals(1, result?.value)
    }

    @Test
    fun addToHead() {
        val linkedList = linkedListOfSize(2)

        linkedList.addAtHead(100)

        assertEquals(100, linkedList.head?.value)
    }

    @Test
    fun addAtIndex() {
        val linkedList = linkedListOfSize(10)

        linkedList.addAtIndex(5, 100)

        assertEquals(100, linkedList.get(5)?.value)
    }

    @Test
    fun addAtIndexEmptyList() {
        val linkedList = LinkedList<Int>()

        linkedList.addAtIndex(0, 100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun addAtEndOfList() {
        val linkedList = linkedListOfSize(4)

        linkedList.addAtIndex(4, 100)

        assertEquals(100, linkedList.get(4)?.value)
    }

    @Test
    fun addAtTail() {
        val linkedList = linkedListOfSize(3)

        linkedList.addAtTail(100)

        assertEquals(100, linkedList.get(3)?.value)
    }

    @Test
    fun addAtTailEmptyList() {
        val linkedList = LinkedList<Int>()

        linkedList.addAtTail(100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun addAtIndexInvalidIgnored() {
        val linkedList = LinkedList<Int>()

        linkedList.addAtIndex(0, 100)

        linkedList.get(0)
    }

    @Test
    fun addAtIndex0() {
        val linkedList = linkedListOf(1, 2, 3)

        linkedList.addAtIndex(0, 100)

        assertEquals(100, linkedList.get(0)?.value)
    }

    @Test
    fun deleteAtIndex() {
        val linkedList = linkedListOfSize(10)

        linkedList.deleteAtIndex(4)

        assertEquals(5, linkedList.get(4)?.value)
    }

    @Test
    fun deleteFirstNode() {
        val linkedList = linkedListOfSize(10)

        linkedList.deleteAtIndex(0)

        assertEquals(1, linkedList.get(0)?.value)
    }

    @Test
    fun linkedListOfCreatesList() {
        val linkedList = linkedListOf(1, 2, 3, 4)

        var curr = linkedList.head
        (1..4).forEach {
            assertEquals(it, curr?.value)
            curr = curr?.next
        }
    }

    @Test
    fun linkedListOfCreatesListOf1() {
        val linkedList = linkedListOf(1)

        assertEquals(1, linkedList.head?.value)
    }

    @Test
    fun isEqual() {
        val linkedList1 = linkedListOfSize(4)
        val linkedList2 = linkedListOfSize(4)

        assertEquals(linkedList1, linkedList2)
    }

    @Test
    fun isNotEqual() {
        val linkedList1 = linkedListOfSize(3)
        val linkedList2 = linkedListOfSize(4)

        assertNotEquals(linkedList1, linkedList2)
    }

    @Test
    fun isEqualEmptyList() {
        val linkedList1 = LinkedList<Int>()
        val linkedList2 = LinkedList<Int>()

        assertEquals(linkedList1, linkedList2)
    }
}

fun linkedListOfSize(size: Int): LinkedList<Int> {
    if (size == 0) return LinkedList()
    val head = LinkedList.Node(0)
    var curr: LinkedList.Node<Int>? = head
    (1 until size).forEach {
        curr?.next = LinkedList.Node(it)
        curr = curr?.next
    }
    return LinkedList(head)
}

fun <T> linkedListOf(vararg values: T): LinkedList<T> {
    val head = LinkedList.Node(values[0])
    var curr: LinkedList.Node<T>? = head
    (1 until values.size).forEach {
        curr?.next = LinkedList.Node(values[it])
        curr = curr?.next
    }
    return LinkedList(head)
}
