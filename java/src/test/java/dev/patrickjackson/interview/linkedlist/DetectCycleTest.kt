package dev.patrickjackson.interview.linkedlist

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class DetectCycleTest {
    @Test
    fun returnHeadOfCycle() = testCycle(2, 4)

    @Test
    fun returnNullWhenNoCycle() {
        val linkedList = linkedListOfSize(10)

        assertNull(detectCycle(linkedList))
    }

    @Test
    fun returnHeadOfCycle1() = testCycle(0, 1)

    @Test
    fun detectCycles() {
        (0..24).zip(1..25) { pos, size ->
            testCycle(pos, size)
        }
    }

    /**
     * Test detectCycle returns the correct start of the cycle.
     * Values of nodes are irreverent
     */
    private fun testCycle(cyclePos: Int, size: Int) {
        val linkedList = linkedListWithCycle(cyclePos, *IntArray(size = size).toTypedArray())
        val startOfCycle = linkedList.get(cyclePos)

        assertSame(startOfCycle, detectCycle(linkedList))
    }
}
