package com.yunseong.algorithm.back13913

import java.util.LinkedList

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(100001) { false }

    val queue = LinkedList<Node>()
    queue.add(Node(n, 0, null))

    var last: Node? = null

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val current = node.value

        if (current == k) {
            last = node
            break
        }

        for (i in listOf(current - 1, current + 1, current * 2)) {
            if (i in 0..100000 && !visited[i]) {
                visited[i] = true
                queue.add(Node(i, node.count + 1, node))
            }
        }
    }

    val text = StringBuffer()

    text.append("${last?.count}\n$n ")
    createText(text, last!!)

    println(text)
}

fun createText(text: StringBuffer, node: Node) {
    if (node.before == null) return
    createText(text, node.before)
    text.append("${node.value} ")
}

data class Node(
    val value: Int,
    val count: Int,
    val before: Node?
)
