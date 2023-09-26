package com.yunseong.algorithm.algorithm.bfs

import com.yunseong.algorithm.Search
import com.yunseong.algorithm.Tree
import com.yunseong.algorithm.graph.Graph
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
    }
}
