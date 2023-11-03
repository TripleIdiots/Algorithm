package com.yunseong.algorithm.back17071

import java.util.LinkedList

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val queue = LinkedList<Triple<Int, Int, Int>>()
    val visited = Array(2) { BooleanArray(500001) { false } }

    queue.add(Triple(n, k, 0))
    visited[0][n] = true

    while (queue.isNotEmpty()) {
        val (s, b, t) = queue.poll()

        if (b > 500000) {
            println(-1)
            return
        }

        if (visited[t % 2][b]) {
            println(t)
            return
        }

        val time = t + 1

        for (i in listOf(s - 1, s + 1, s * 2)) {
            if (i in 0..500000 && !visited[time % 2][i]) {
                visited[time % 2][i] = true
                queue.add(Triple(i, b + time, time))
            }
        }
    }
}