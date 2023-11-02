package src.backjoon

import common.Solution
import java.util.*

class BackJoon_2636: Solution {
    private var N = -1
    private var M = -1
    private lateinit var map: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(1, -1, 0, 0)
    private var hours = 1
    private var count = 0


    override fun solution() {
        init()
        while (true) {
            //녹을 치즈 마킹
            marking()

            //다 녹았나?
            val containsOnlyZerosAndTwos = map.all { row ->
                row.all { element -> element == 0 || element == 2 }
            }

            //다 녹았다면 count setting
            if (containsOnlyZerosAndTwos) {
                setCount()
                break
            }

            //다 녹지 않았다면 녹임
            remove()

            //시간 증가
            hours++
        }
        println(hours)
        println(count)
    }
    private fun init() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        N = A
        M = B
        map = Array(N) { IntArray(M) { 0 } }
        visited = Array(N) { BooleanArray(M) { false } }
        for (i: Int in 0 until N) {
            val line = readln().split(" ").map { it.toInt() }
            for (j: Int in 0 until M) {
                map[i][j] = line[j]
                if (map[i][j] == 1) {
                    queue.offer(Pair(i, j))
                }
            }
        }
    }

    private fun marking() {
        for (i: Int in 0 until N) {
            for (j: Int in 0 until M) {
                if (map[i][j] == 1) {
                    mark(i, j)
                }
            }
        }
    }

    private fun remove() {
        for (i: Int in 0 until N) {
            for (j: Int in 0 until M) {
                if (map[i][j] == 2) {
                    map[i][j] = 0
                }
            }
        }
    }

    private fun setCount() {
        for (i: Int in 0 until N) {
            for (j: Int in 0 until M) {
                if (map[i][j] == 2) {
                    count++
                }
            }
        }
    }

    fun mark(x: Int, y: Int): Int {
        var temp = 0
        for (i: Int in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
            if (map[nx][ny] == 0) {
                if (bfs(nx, ny)) {
                    map[x][y] = 2
                    temp++
                }
            }
        }
        return temp
    }


    fun bfs(x: Int, y: Int): Boolean {
        val temp: Queue<Pair<Int, Int>> = LinkedList()
        val tempVisited = Array(N) { BooleanArray(M) { false } }
        temp.offer(Pair(x, y))
        while (temp.isNotEmpty()) {
            val (x2, y2) = temp.poll()
            for (i: Int in 0 until 4) {
                val nx = x2 + dx[i]
                val ny = y2 + dy[i]
                if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
                if (tempVisited[nx][ny]) continue
                if (map[nx][ny] == 1 || map[nx][ny] == 2) continue
                if (nx == 0 || ny == 0 || nx == map.size - 1 || ny == map[0].size - 1) {
                    if (map[nx][ny] == 0) {
                        return true
                    }
                } else {
                    tempVisited[nx][ny] = true
                    temp.offer(Pair(nx, ny))
                }
            }
        }
        return false
    }
}