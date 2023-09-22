package com.yunseong.algorithm.tree.bfs

import com.yunseong.algorithm.tree.Direction
import com.yunseong.algorithm.tree.Node
import com.yunseong.algorithm.tree.Tree
import org.junit.jupiter.api.Test

class BreadthFirstSearchTest {

    @Test
    fun `BFS 동작 테스트`() {
        // given
        val tree: Tree<Int> = Tree()

        val search = BreadthFirstSearch()

        val rootNode = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)
        val node5 = Node(5)
        val node6 = Node(6)
        val node7 = Node(7)
        val node8 = Node(8)
        val node9 = Node(9)

        tree.search = search

        tree.rootNode = rootNode
        rootNode[Direction.LEFT] = node2
        rootNode[Direction.RIGHT] = node3
        node2[Direction.LEFT] = node4
        node2[Direction.RIGHT] = node5
        node3[Direction.LEFT] = node6
        node3[Direction.RIGHT] = node7
        node4[Direction.LEFT] = node8
        node4[Direction.RIGHT] = node9

        // when
        tree.search()

        // then
    }
}
