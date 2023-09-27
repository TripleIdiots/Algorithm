package com.yunseong.algorithm.algorithm.bfs

import com.yunseong.algorithm.Search
import com.yunseong.algorithm.Tree
import com.yunseong.algorithm.graph.Graph
import com.yunseong.algorithm.graph.Vertex
import com.yunseong.algorithm.queue.Queue

class BreadthFirstSearch : Search {

    override fun <T> search(tree: Tree<T>) {
        val queue = Queue(Pair(0, tree.rootNode!!))
        var text = tree.rootNode.toString()

        var lastIndex = 1

        while (queue.hasValue()) {
            val node = queue.dequeue().getOrThrow()

            if (node.first != lastIndex) {
                text += "\n"
            }

            lastIndex = node.first

            node.second.getChildren().forEach {
                queue.enqueue(Pair(node.first.inc(), it))
                text += it.data.toString() + " "
            }
        }

        println(text)
    }

    override fun <T> search(graph: Graph<T>) {
        var vertex = graph.from(2)
        val queue = Queue(graph[vertex])
        val visited = mutableListOf<Vertex<T>>()

        println(vertex.data)
        visited.add(vertex)

        while (queue.hasValue()) {
            val node = queue.dequeue().getOrThrow()
            for (n in node) {
                if (visited.contains(n.destination)) {
                    continue
                }
                vertex = n.destination
                println(vertex.data)
                visited.add(vertex)
                queue.enqueue(graph[vertex]!!)
            }
        }
    }
}
