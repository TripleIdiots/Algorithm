package backjoon

import common.Solution

class BackJoon_1987 : Solution {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val visited = Array(26) { false }
    var max = -1
    lateinit var map: Array<Array<Int>>
    fun backTracking(x: Int, y: Int, count: Int) {
        //이미 방문한 알파벳이라면
        if (visited[map[x][y]]) {
            //조건 만족으로 최댓값 경신 후 종료
            max = Math.max(count, max)
            return
        } else {
            for (i: Int in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
                //탐색 할 노드 방문 처리
                visited[map[x][y]] = true
                //다음 노드 기준으로 찾아봄
                backTracking(nx, ny, count + 1)
                //다시 탐색을 위해 방문 해제
                visited[map[x][y]] = false
            }
        }
    }

    override fun solution() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        map = Array(N) { Array(M) { 0 } }
        for (i: Int in 0 until N) {
            val line = readln().split("").filter { it.isNotEmpty() }
            for (j: Int in 0 until M) {
                map[i][j] = line[j].first() - 'A'
            }
        }
        backTracking(0, 0, 0)
        println(max)
    }
}