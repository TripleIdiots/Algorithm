package com.yunseong.algorithm

data class Node<T>(
    val data: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
) {

    fun getChildren(): List<Node<T>> {
        return listOfNotNull(left, right)
    }

    override fun toString(): String {
        return data.toString()
    }
}
