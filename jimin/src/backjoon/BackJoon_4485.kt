package src.backjoon

import common.Solution
import java.util.*

class BackJoon_4485: Solution {
    data class Place(
        val x: Int,
        val y: Int,
        val cost: Int
    ) : Comparable<Place> {
        override fun compareTo(other: Place): Int {
            if (this.cost > other.cost) {
                return 1
            }
            return -1
        }
    }

    private val priorityQueue = PriorityQueue<Place>()

    lateinit var map: Array<Array<Place>>
    lateinit var visited: Array<BooleanArray>
    val result = StringBuilder()

    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(1, -1, 0, 0)
    override fun solution() {
        var index = 1
        while (true) {
            val N = readln().toInt()
            if (N == 0) break
            val distance = init(N)
            search(N, distance)
            result.append("Problem $index: ${distance[N-1][N-1]}").append("\n")
            index++
        }
        print(result)
    }

    private fun search(N: Int, distance: Array<IntArray>) {
        while (priorityQueue.isNotEmpty()) {
            val (x, y, cost) = priorityQueue.poll()
            if (visited[x][y]) continue
            visited[x][y] = true

            for (i: Int in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue
                if (visited[nx][ny]) continue

                if (distance[nx][ny] > cost + map[nx][ny].cost) {
                    distance[nx][ny] = cost + map[nx][ny].cost
                    priorityQueue.add(Place(nx, ny, distance[nx][ny]))
                }
            }
        }
    }

    private fun init(N: Int): Array<IntArray> {
        val distance = Array(N) { IntArray(N) { Int.MAX_VALUE } }
        map = Array(N) { Array(N) { Place(0, 0, 0) } }
        visited = Array(N) { BooleanArray(N) { false } }
        for (i in 0 until N) {
            val line = readln().split(" ").map { it.toInt() }
            for (j: Int in 0 until N) {
                map[i][j] = Place(i, j, line[j])
            }
        }
        distance[0][0] = map[0][0].cost
        priorityQueue.offer(Place(0, 0, distance[0][0]))
        return distance
    }
}