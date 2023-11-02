package src.backjoon

import common.Solution

class BackJoon_11657: Solution {
    data class Bus(
        val to: Int,
        val vertex: Int,
        val cost: Long
    )

    lateinit var graph: Array<Bus>
    lateinit var dist: LongArray
    var n = -1
    var m = -1

    override fun solution() {
        val (V, M) = readln().split(" ").map { it.toInt() }
        n = V
        m = M
        graph = Array(M + 1) { Bus(0, 0, 0) }
        for (i: Int in 0 until m) {
            val (u, v, w) = readln().split(" ").map { it.toInt() }
            graph[i] = Bus(u, v, w.toLong())
        }
        dist = LongArray(V + 1) { Long.MAX_VALUE }
        //간선 체크
        val check = check(1)
        printDistance(check)
    }


    private fun check(start: Int): Boolean {
        dist[start] = 0
        for (i: Int in 1..n) {
            for (j: Int in 0 until m) {
                val u = graph[j].to
                val v = graph[j].vertex
                val w = graph[j].cost
                if (dist[u] != Long.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w
                }
            }
        }
        for (i: Int in 0 until m) {
            val u = graph[i].to
            val v = graph[i].vertex
            val w = graph[i].cost
            if (dist[u] != Long.MAX_VALUE && dist[u] + w < dist[v]) {
                return true
            }
        }
        return false
    }

    private fun printDistance(result: Boolean) {
        if (result) {
            println(-1)
        } else {
            for (i: Int in 2 until dist.size) {
                if (dist[i] == Long.MAX_VALUE) println(-1)
                else println(dist[i])
            }
        }
    }

}