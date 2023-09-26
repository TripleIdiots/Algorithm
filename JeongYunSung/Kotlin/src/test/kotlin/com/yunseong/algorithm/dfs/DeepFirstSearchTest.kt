package com.yunseong.algorithm.dfs

import com.yunseong.algorithm.GraphTest
import com.yunseong.algorithm.algorithm.dfs.DeepFirstSearch
import com.yunseong.algorithm.graph.Graph

class DeepFirstSearchTest {

    @GraphTest(intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
    fun `Graph에서 DFS 동작 테스트`(graph: Graph<Int>) {
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

        graph.search(DeepFirstSearch())
    }
}
