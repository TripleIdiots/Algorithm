package com.yunseong.algorithm.tree

import com.yunseong.algorithm.Element
import com.yunseong.algorithm.Search
import com.yunseong.algorithm.queue.Queue

class Tree<T>(
    var rootNode: Node<T>? = null
) : Element {

    fun addNode(node: Node<T>) {
        if (this.rootNode == null) {
            this.rootNode = node
            return
        }

        val queue: Queue<Node<T>> = Queue(this.rootNode!!)

        while (queue.hasValue()) {
            val currentNode = queue.dequeue().getOrThrow()

            if (currentNode.left == null) {
                currentNode.left = node
                return
            }

            if (currentNode.right == null) {
                currentNode.right = node
                return
            }

            currentNode.getChildren().forEach {
                queue.enqueue(it)
            }
        }
    }

    override fun search(search: Search) {
        search.search(this)
    }
}
