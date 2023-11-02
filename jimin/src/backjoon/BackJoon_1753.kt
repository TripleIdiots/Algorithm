package src.backjoon

import common.Solution
import java.util.*

class BackJoon_1753: Solution {
    private val priorityQueue = PriorityQueue<Edge>()
    class Edge(
        val vertex: Int,
        val value: Int
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            if (this.value > other.value) {
                return 1
            }
            return -1
        }
    }
    override fun solution() {
        val (V, E) = readln().split(" ").map { it.toInt() }
        val K = readln().toInt()
        val graph = Array(V + 1) { mutableListOf<Edge>() }
        for (i: Int in 0 until E) {
            val (u, v, w) = readln().split(" ").map { it.toInt() }
            graph[u].add(Edge(v, w))
        }
        val visited = BooleanArray(V + 1)
        //전체 거리 초기화
        val distance = IntArray(V + 1) { Int.MAX_VALUE }
        distance[K] = 0
        priorityQueue.add(Edge(K, 0))
        while (priorityQueue.isNotEmpty()) {
            val edge = priorityQueue.poll()
            val vertex = edge.vertex
            val value = edge.value
            //이미 방문한 간선이면 안 함
            if (visited[vertex]) continue
            visited[vertex] = true
            for (i in graph[vertex]) {
                //현재 거리가 다른 노드를 거쳤을때 보면 크면 작은 값으로 코스트 갱신
                if (distance[i.vertex] > value + i.value) {
                    distance[i.vertex] = value + i.value
                    //다음 간선으로 이동시킴
                    priorityQueue.add(Edge(i.vertex, distance[i.vertex]))
                }
            }
        }
        resultPrint(V, distance)
    }

    private fun resultPrint(V: Int, distance: IntArray) {
        for (i: Int in 1..V) {
            if (distance[i] == Int.MAX_VALUE) {
                println("INF")
            } else {
                println(distance[i])
            }
        }
    }
}