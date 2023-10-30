package com.yunseong.algorithm.back12851

import java.util.LinkedList

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val queue = LinkedList<Int>()
    val nodes = Array(100001) { Node() }

    queue.add(n)
    nodes[n].visitedCount = 1
    nodes[n].isVisited = true

    while (queue.isNotEmpty()) {
        val index = queue.poll()

        for (i in listOf(index - 1, index + 1, index * 2)) {
            if (i < 0 || i > 100000) continue

            if (!nodes[i].isVisited) {
                nodes[i].isVisited = true
                nodes[i].depth = nodes[index].depth + 1
                nodes[i].visitedCount = nodes[index].visitedCount
                queue.add(i)
            } else if (nodes[i].depth == (nodes[index].depth + 1)) {
                nodes[i].visitedCount += nodes[index].visitedCount
            }
        }
    }

    println(nodes[k].depth)
    println(nodes[k].visitedCount)
}

data class Node(
    var isVisited: Boolean = false,
    var depth: Int = 0,
    var visitedCount: Int = 0
)
