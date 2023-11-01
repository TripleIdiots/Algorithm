package com.yunseong.algorithm.back13549

import java.util.PriorityQueue

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dist = Array(100001) { Int.MAX_VALUE }
    val pq = PriorityQueue<Int>()

    dist[n] = 0
    pq.add(n)

    while (pq.isNotEmpty()) {
        val value = pq.poll()

        for (i in listOf(value + 1 to 1, value - 1 to 1, value * 2 to 0)) {
            if (i.first < 0 || i.first > 100000) continue

            val cost = dist[value] + i.second

            if (dist[i.first] > cost) {
                dist[i.first] = cost
                pq.add(i.first)
            }
        }
    }

    println(dist[k])
}
