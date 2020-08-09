package dev.patrickjackson

import dev.patrickjackson.interview.trees.IntTreeNode
import dev.patrickjackson.interview.trees.IntTreeSerializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 *
 [1,2,3]
    1
   / \
 2    3

 [1, null, 2, null, 3]
    1
     \
      2
       \
        3
 */
class IntTreeSerializerTest {

    @Test
    fun createBst() {
        val treeSerializer = IntTreeSerializer()
        val r = IntTreeNode(1)
        r.left = IntTreeNode(2)
        r.right = IntTreeNode(3)
        assertEquals("1,2,null,null,3,null,null,", treeSerializer.serialize(r))

        val root = treeSerializer.deserialize("1,2,null,null,3,null,null,")

        assertEquals(1, root?.value)
        assertEquals(2, root?.left?.value)
        assertEquals(3, root?.right?.value)
    }
}

