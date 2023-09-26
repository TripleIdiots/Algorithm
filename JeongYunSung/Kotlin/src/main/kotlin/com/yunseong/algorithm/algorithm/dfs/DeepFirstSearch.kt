package com.yunseong.algorithm.algorithm.dfs

import com.yunseong.algorithm.Search
import com.yunseong.algorithm.graph.Graph
import com.yunseong.algorithm.graph.Vertex
import com.yunseong.algorithm.Tree

class DeepFirstSearch : Search {

    override fun <T> search(tree: Tree<T>) {
    }

    override fun <T> search(graph: Graph<T>) {
        dfsForGraph(graph, graph.from(0))
    }

    private fun <T> dfsForGraph(graph: Graph<T>, vertex: Vertex<T>, visited: MutableSet<Vertex<T>> = mutableSetOf()) {
        visited.add(vertex)
        println(vertex.data)

        graph[vertex]?.forEach {
            if (!visited.contains(it.destination)) {
                dfsForGraph(graph, it.destination, visited)
            }
        }
    }
}
