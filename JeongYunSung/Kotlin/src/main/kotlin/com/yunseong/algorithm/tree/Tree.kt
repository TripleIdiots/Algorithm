package com.yunseong.algorithm.tree

class Tree<T>(
    var rootNode: Node<T>? = null,
    var search: Search? = null
) {

    fun setLeftNode(node: Node<T>, leftNode: Node<T>) {
        node[Direction.LEFT] = leftNode
    }

    fun setRightNode(node: Node<T>, rightNode: Node<T>) {
        node[Direction.RIGHT] = rightNode
    }

    fun search() {
        this.search?.search(this)
    }
}
