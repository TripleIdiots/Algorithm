package com.yunseong.algorithm.back1753

import java.util.LinkedList
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val graph = mutableMapOf<Int, LinkedList<Pair<Int, Int>>>()

    val (v, e) = readln().split(" ").map { it.toInt() }
    val start = readln().toInt()

    for (i in 0 until e) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }

        if (graph[u] == null) {
            graph[u] = LinkedList()
        }

        graph[u]!!.add(Pair(v, w))
    }

    val dist = IntArray(v + 1) { Int.MAX_VALUE }
    val visited = BooleanArray(v + 1)
    val priorityQueue = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }

    dist[start] = 0
    priorityQueue.add(Pair(start, 0))

    while (priorityQueue.isNotEmpty()) {
        val (current, currentCost) = priorityQueue.poll()

        if (visited[current]) {
            continue
        }

        if (graph[current] == null) {
            continue
        }

        visited[current] = true

        for (next in graph[current]!!) {
            val cost = currentCost + next.second

            if (dist[next.first] > cost) {
                dist[next.first] = cost
                priorityQueue.add(Pair(next.first, cost))
            }
        }
    }

    val sb = StringBuilder()

    for (i in 1..v) {
        if (dist[i] == Int.MAX_VALUE) {
            sb.append("INF\n")
        } else {
            sb.append("${dist[i]}\n")
        }
    }

    print(sb)
}
