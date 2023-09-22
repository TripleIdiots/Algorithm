package com.yunseong.algorithm.tree.bfs

import com.yunseong.algorithm.queue.Queue
import com.yunseong.algorithm.tree.Search
import com.yunseong.algorithm.tree.Tree

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
}
