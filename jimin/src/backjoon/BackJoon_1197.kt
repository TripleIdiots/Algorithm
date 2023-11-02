package src.backjoon

import common.Solution
import java.util.*

class BackJoon_1197: Solution {
    data class Edge(
        val x: Int,
        val y: Int,
        val vertex: Int
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            if (this.vertex > other.vertex) {
                return 1
            }
            return -1
        }
    }

    override fun solution() {
        var reuslt = 0
        val (V, M) = readln().split(" ").map { it.toInt() }
        val parent = IntArray(V) { 0 }
        val edges = PriorityQueue<Edge>()
        //초기 부모 노드는 자기 자신으로 세팅
        for (i: Int in 1..V) {
            parent[i - 1] = i
        }

        for (i: Int in 0 until M) {
            val (u, v, w) = readln().split(" ").map { it.toInt() }
            edges.offer(Edge(u, v, w))
        }

        var cnt = 0
        while (edges.isNotEmpty()) {
            val edge = edges.poll()
            if (getParent(parent, edge.x) != getParent(parent, edge.y)) {
                unionParent(parent, edge.x, edge.y)
                reuslt += edge.vertex
                cnt++
            }
            //모든 정점을 방문 했으면 정지 (시간 최적화)
            if (cnt == V - 1) break
        }
        println(reuslt)
    }

    private fun getParent(parent: IntArray, x: Int): Int {
        if (parent[x - 1] == x) {
            return x
        }
        return getParent(parent, parent[x - 1])
    }

    private fun unionParent(parent: IntArray, a: Int, b: Int) {
        val parentA = getParent(parent, a) // a의 부모
        val parentB = getParent(parent, b) // b의 부모
        // 더 작은 값을 부모로 설정

        if (parentA < parentB) {
            parent[parentB - 1] = parentA

        } else {
            parent[parentA - 1] = parentB
        }
    }

}