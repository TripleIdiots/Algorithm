package com.yunseong.algorithm.back1916

import java.util.LinkedList
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val vertex = readln().toInt()
    val edge = readln().toInt()

    val graph = hashMapOf(*(0..vertex).map {
        it to LinkedList<Pair<Int, Int>>()
    }.toTypedArray())

    for (i in 0..<edge) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u]!!.add(Pair(v, w))
    }

    val (start, end) = readln().split(" ").map { it.toInt() }

    val dist = IntArray(vertex + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.second - o2.second }
    pq.add(Pair(start, 0))
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val (v, w) = pq.poll()

        if (dist[v] < w) continue

        for (i in graph[v]!!) {
            val (nv, nw) = i
            if (dist[nv] > w + nw) {
                dist[nv] = w + nw
                pq.add(Pair(nv, w + nw))
            }
        }
    }

    println(dist[end])
}