package com.yunseong.algorithm.bfs

import com.yunseong.algorithm.GraphTest
import com.yunseong.algorithm.Tree
import com.yunseong.algorithm.TreeTest
import com.yunseong.algorithm.algorithm.bfs.BreadthFirstSearch
import com.yunseong.algorithm.graph.Graph

class BreadthFirstSearchTest {

    @TreeTest(intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20])
    fun `Tree에서 BFS 동작 테스트`(tree: Tree<Int>) {
        tree.search(BreadthFirstSearch())
    }

    @GraphTest(intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
    fun `Graph에서 BFS 동작 테스트`(graph: Graph<Int>) {
        graph.addDirectedEdge(graph.from(0), graph.from(1))
        graph.addDirectedEdge(graph.from(0), graph.from(7))
        graph.addDirectedEdge(graph.from(0), graph.from(8))
        graph.addDirectedEdge(graph.from(1), graph.from(2))
        graph.addDirectedEdge(graph.from(1), graph.from(4))
        graph.addDirectedEdge(graph.from(1), graph.from(6))
        graph.addDirectedEdge(graph.from(2), graph.from(3))
        graph.addDirectedEdge(graph.from(2), graph.from(5))
        graph.addDirectedEdge(graph.from(3), graph.from(4))
        graph.addDirectedEdge(graph.from(8), graph.from(9))
        graph.addDirectedEdge(graph.from(8), graph.from(12))
        graph.addDirectedEdge(graph.from(8), graph.from(14))
        graph.addDirectedEdge(graph.from(9), graph.from(10))
        graph.addDirectedEdge(graph.from(9), graph.from(11))
        graph.addDirectedEdge(graph.from(12), graph.from(11))
        graph.addDirectedEdge(graph.from(12), graph.from(13))

        graph.search(BreadthFirstSearch())
    }

    @GraphTest(intArray = [1, 2, 3, 4])
    fun `Graph에서 BFS 동작 테스트2`(graph: Graph<Int>) {
        graph.addNonDirectedEdge(graph.from(0), graph.from(1))
        graph.addNonDirectedEdge(graph.from(0), graph.from(2))
        graph.addNonDirectedEdge(graph.from(0), graph.from(3))
        graph.addNonDirectedEdge(graph.from(1), graph.from(3))
        graph.addNonDirectedEdge(graph.from(2), graph.from(3))

        graph.search(BreadthFirstSearch())
    }
}
