package src.backjoon

import common.Solution
import java.util.*

class BackJoon_11779: Solution {
    data class Edge(
        val vertex: Int,
        val cost: Int,
        var before: Edge? = null
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            if (this.cost > other.cost) {
                return 1
            }
            return -1
        }
    }

    private val queue = PriorityQueue<Edge>()

    override fun solution() {
        val V = readln().toInt()
        val M = readln().toInt()
        val distance = IntArray(V + 1) { Int.MAX_VALUE }
        val graph = Array(V + 1) { mutableListOf<Edge>() }
        val visited = BooleanArray(V + 1)
        for (i: Int in 0 until M) {
            val (u, v, w) = readln().split(" ").map { it.toInt() }
            graph[u].add(Edge(v, w))
        }
        val (start, end) = readln().split(" ").map { it.toInt() }

        val startEdge= Edge(start, 0)
        queue.add(startEdge)
        distance[start] = 0

        var last: Edge? = startEdge

        while (queue.isNotEmpty()) {
            val data = queue.poll()
            val (vertex, cost) = data
            if (visited[vertex]) continue
            visited[vertex] = true
            for (edge in graph[vertex]) {
                if (distance[edge.vertex] > edge.cost + cost) {
                    edge.before = data

                    distance[edge.vertex] = edge.cost + cost
                    queue.add(Edge(edge.vertex, distance[edge.vertex], data))

                    if (edge.vertex == end) {
                        last = edge
                    }
                }
            }
        }
        createText(last)
        println(distance[end])
        println(count)
        println(builder.toString())
    }

    private val builder = StringBuilder()
    private var count = 0

    private fun createText(edge: Edge?) {
        if (edge == null) return
        createText(edge.before)
        count++
        builder.append("${edge.vertex} ")
    }
}