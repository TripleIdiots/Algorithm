package com.yunseong.algorithm.back1697

import java.util.LinkedList

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val queue = LinkedList<Pair<Int, Int>>()
    val visited = BooleanArray(100001) { false }

    queue.add(n to 0)

    while (queue.isNotEmpty()) {
        val x = queue.poll()

        if (x.first == k) {
            println(x.second)
            break
        }

        if (x.first >= 0 && x.first < visited.size && !visited[x.first]) {
            visited[x.first] = true

            queue.add(x.first - 1 to x.second + 1)
            queue.add(x.first + 1 to x.second + 1)
            queue.add(x.first * 2 to x.second + 1)
        }
    }
}
