package src.backjoon

import common.Solution
import java.util.*

class BackJoon_1916: Solution {
    private val priorityQueue = PriorityQueue<Edge>()

    data class Edge(
        val vertex: Int,
        val cost: Int
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            if (this.cost > other.cost) {
                return 1
            }
            return -1
        }
    }

    override fun solution() {
        val N = readln().toInt()
        val M = readln().toInt()
        val graph = Array(N + 1) { mutableListOf<Edge>() }
        val distance = IntArray(N + 1) { Int.MAX_VALUE }
        val visited = BooleanArray(N + 1) { false }
        for (i: Int in 0 until M) {
            val (v, u, w) = readln().split(" ").map { it.toInt() }
            graph[v].add(Edge(u, w))
        }
        val (start, end) = readln().split(" ").map { it.toInt() }

        priorityQueue.add(Edge(start, 0))
        distance[start] = 0

        while (priorityQueue.isNotEmpty()) {
            val cur = priorityQueue.poll()
            val cost = cur.cost
            val vertex = cur.vertex

            if (visited[cur.vertex]) continue
            visited[cur.vertex] = true

            for (i in graph[vertex]) {
                if (distance[i.vertex] > cost + i.cost) {
                    distance[i.vertex] = cost + i.cost
                    priorityQueue.add(Edge(i.vertex, distance[i.vertex]))
                }
            }
        }
        println(distance[end])
    }

}