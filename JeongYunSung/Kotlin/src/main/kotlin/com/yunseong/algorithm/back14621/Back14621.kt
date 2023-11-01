package com.yunseong.algorithm.back14621

import java.util.PriorityQueue

lateinit var parents: IntArray

fun main(args: Array<String>) {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = readln().split(" ").map {
        when (it) {
            "M" -> 0
            else -> 1
        }
    }

    parents = IntArray(n) { it }

    val edges = PriorityQueue<Triple<Int, Int, Int>> { o1, o2 ->
        o1.third - o2.third
    }

    for (i in 0 until m) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }

        if (graph[u - 1] == graph[v - 1]) continue

        edges.add(Triple(u - 1, v - 1, w))
    }

    var cost = 0
    var count = 0

    while (edges.isNotEmpty()) {
        val edge = edges.poll()

        if (isUnion(edge.first, edge.second)) continue

        cost += edge.third
        union(edge.first, edge.second)

        if (++count == n - 1) break
    }

    if (count != n - 1) {
        println(-1)
    } else {
        println(cost)
    }
}

fun find(x: Int): Int {
    if (x == parents[x]) return x
    parents[x] = find(parents[x])
    return parents[x]
}

fun isUnion(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    return px == py
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)

    if (px < py) {
        parents[py] = px
    } else {
        parents[px] = py
    }
}
