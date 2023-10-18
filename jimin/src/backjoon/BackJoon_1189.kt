package backjoon

import common.Solution

class BackJoon_1189 : Solution {
    var N = -1
    var M = -1
    var K = -1
    lateinit var map: Array<Array<String>>
    var ans = 0
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    lateinit var visited: Array<BooleanArray>

    fun bfs(x: Int, y: Int, move: Int) {
        if (x == 0 && y == M - 1) {
            if (move == K) {
                ans++
            }
            return
        }
        for (i: Int in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
            if (!visited[nx][ny] && map[nx][ny] != "T") {
                visited[nx][ny] = true
                bfs(nx, ny, move + 1)
                visited[nx][ny] = false
            }
        }
    }

    override fun solution() {
        val (A, B, C) = readln().split(" ").map { it.toInt() }
        N = A
        M = B
        K = C
        map = Array(N) { Array(M) { "" } }
        visited = Array(N) { BooleanArray(M) { false } }
        for (i: Int in 0 until N) {
            val line = readln().split("").filter { it.isNotEmpty() }
            for (j: Int in 0 until M) {
                map[i][j] = line[j]
            }
        }
        visited[N - 1][0] = true
        bfs(N - 1, 0, 1)
        println(ans)
    }
}