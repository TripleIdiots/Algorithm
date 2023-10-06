package com.yunseong.algorithm.back1260

import org.junit.jupiter.api.Test

class Graph1260Test {

    @Test
    fun `1260테스트`() {
        val graph = Graph1260()

        graph.addVertex(1)
        graph.addVertex(2)
        graph.addVertex(3)
        graph.addVertex(4)
        graph.addVertex(5)

        graph.addEdge(5, 4)
        graph.addEdge(5, 2)
        graph.addEdge(1, 2)
        graph.addEdge(3, 4)
        graph.addEdge(3, 1)

        graph.dfs(3)
        println()
        graph.bfs(3)
    }
}
