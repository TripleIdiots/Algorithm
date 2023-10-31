package com.yunseong.algorithm.back7576

import java.util.LinkedList

fun main(args: Array<String>) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val array = Array(n) { IntArray(m) }
    val startPoint = mutableListOf<Triple<Int, Int, Int>>()
    var count = 0

    for (i in 0 until n) {
        val line = readln().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            array[i][j] = line[j]

            when (line[j]) {
                1 -> startPoint.add(Triple(i, j, 0))
                0 -> count++
            }
        }
    }

    val queue = LinkedList<Triple<Int, Int, Int>>()
    val visited = Array(n) { BooleanArray(m) }
    startPoint.forEach {
        queue.add(it)
    }

    var lastDay = 0

    while (queue.isNotEmpty()) {
        val (y, x, d) = queue.poll()

        if (lastDay < d) lastDay = d

        if (array[y][x] != 1) continue

        for (i in listOf(0 to -1, 0 to 1, 1 to 0, -1 to 0)) {
            val (ny, nx) = y + i.second to x + i.first

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || array[ny][nx] != 0) continue

            visited[ny][nx] = true
            array[ny][nx] = 1
            queue.add(Triple(ny, nx, d + 1))
            count--
        }
    }

    when (count) {
        0 -> println(lastDay)
        else -> println(-1)
    }
}
