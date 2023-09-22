package com.yunseong.algorithm.tree

data class Node<T>(
    val data: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
) {

    operator fun set(direction: Direction, value: Node<T>) {
        when (direction) {
            Direction.LEFT -> left = value
            Direction.RIGHT -> right = value
        }
    }

    fun getChildren(): List<Node<T>> {
        return listOfNotNull(left, right)
    }

    override fun toString(): String {
        return data.toString()
    }
}
