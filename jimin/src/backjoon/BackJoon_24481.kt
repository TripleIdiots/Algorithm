package src.backjoon

import common.Solution
private lateinit var temp: IntArray
class BackJoon_24481 : Solution {

    override fun solution() {
        val (N, M, K) = readln().split(" ").map { it.toInt() }
        val graph = Graph(N)
        for (i: Int in 0 until M) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            graph.putNode(x, y)
        }
        temp = IntArray(N + 1) { -1 }
        graph.sorted()
        graph.bfs(K, 0)
        for (i: Int in 1..N) {
            println(temp[i])
        }
    }

    class Graph(n: Int) {
        private val nodes = Array(n + 1) { ArrayList<Int>() }
        private val visited = BooleanArray(n + 1)

        fun putNode(x: Int, y: Int) {
            this.nodes[x].add(y)
            this.nodes[y].add(x)
        }

        fun bfs(index: Int, depth: Int) {
            temp[index] = depth
            visited[index] = true
            val ints = this.nodes[index]
            for (int in ints) {
                if (!visited[int]) {
                    visited[int] = true
                    bfs(int, depth + 1)
                }
            }
        }

        fun sorted() {
            for (element in nodes) {
                element.sort()
            }
        }
    }
}