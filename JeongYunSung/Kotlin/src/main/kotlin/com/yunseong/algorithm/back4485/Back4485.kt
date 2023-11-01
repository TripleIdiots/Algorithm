package com.yunseong.algorithm.back4485

import java.util.PriorityQueue

fun main(args: Array<String>) {
    var count = 0
    val print = StringBuffer()

    while (true) {
        val result = solve()

        if (result == -1) break

        print.append("Problem ${++count}: $result\n")
    }
    print(print)
}

fun solve(): Int {
    val v = readln().toInt()

    if (v == 0) return -1

    val graph = Array(v) { IntArray(v) }

    for (i in 0 until v) {
        val line = readln().split(" ").map { it.toInt() }
        for (j in line.indices) {
            graph[i][j] = line[j]
        }
    }

    val dist = Array(v) { IntArray(v) { Int.MAX_VALUE } }
    val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>> { o1, o2 -> o1.second - o2.second }

    dist[0][0] = 0
    pq.add(Pair(0 to 0, 0))

    while (pq.isNotEmpty()) {
        val (pos, w) = pq.poll()

        if (dist[pos.second][pos.first] < w) continue

        for (i in listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)) {
            val next = pos.first + i.first to pos.second + i.second
            if (next.first < 0 || next.first >= v || next.second < 0 || next.second >= v) continue

            val nextW = w + graph[next.second][next.first]
            if (dist[next.second][next.first] > nextW) {
                dist[next.second][next.first] = nextW
                pq.add(next to nextW)
            }
        }
    }

    return dist[v - 1][v - 1] + graph[0][0]
}
