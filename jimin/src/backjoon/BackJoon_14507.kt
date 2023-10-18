package src.backjoon

import common.Solution
import java.util.*

class BackJoon_14507: Solution {
    private lateinit var map: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private val directionMap = mutableMapOf<Int, Pair<Int, Int>>()
    private var count = 0
    private var direct = -1
    private var cleanIndex = 0
    override fun solution() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val (startX, startY, direction) = readln().split(" ").map { it.toInt() }
        init(N, M, direction)
        bfs(startX, startY)
        println(count)
    }

    private val dx = intArrayOf(0, 0, -1, 1)
    private val dy = intArrayOf(1, -1, 0, 0)


    fun bfs(x: Int, y: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(x, y))
        visited[x][y] = true
        var index = -1
        if (map[x][y] == 0) {
            count++
            map[x][y] = index
        }

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            //청소
            clean(x, y)

            //4분면 탐색
            val (flag, rotate) = searchGround(x, y)
            //빈 칸이 없는 경우
            if (flag) {
                val (bx, by) = back(x, y)
                //후진 할 수 없음 정지
                if (bx < 0 || by < 0 || bx >= map.size || by >= map[0].size) continue
                //벽으로 후진 못함
                if (map[bx][by] == 1) break

                //1번으로 돌아감
                queue.offer(Pair(bx, by))
                visited[bx][by] = true
                continue
            }
            //빈 칸이 있음
            if (rotate) {
                //로봇의 현재 방향을 반시계로 90도 회전
                rotate()
                val (directX, directY) = directionMap[direct]!!
                val nx = x + directX
                val ny = y + directY
                if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) {
                    queue.offer(Pair(x, y))
                    continue
                }
                //전진을 못하는 상황
                if (map[nx][ny] != 0) {
                    //1번으로 돌아감
                    queue.offer(Pair(x, y))
                }
                //전진 가능한 상태
                if (map[nx][ny] == 0) {
                    //전진 후 1번으로 돌아감
                    queue.offer(Pair(nx, ny))
                    visited[nx][ny] = true
                    continue
                }
            }
        }
    }

    private fun searchGround(
        x: Int,
        y: Int,
    ): Pair<Boolean, Boolean> {
        var flag = true
        var rotate = false
        for (i: Int in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx < 0 || nx >= map.size || ny < 0 || ny >= map[0].size) continue
            if (!visited[nx][ny] && map[nx][ny] == 0) {
                flag = false
                //90도 회전
                rotate = true
                break
            }
        }
        return Pair(flag, rotate)
    }

    private fun clean(x: Int, y: Int) {
        if (map[x][y] == 0) {
            count++
            map[x][y] = cleanIndex - 1
            cleanIndex--
        }
    }

    private fun rotate() {
        when (direct) {
            0 -> direct = 3
            1 -> direct = 0
            2 -> direct = 1
            3 -> direct = 2
        }
    }

    private fun back(x: Int, y: Int): Pair<Int, Int> {
        var backX = Int.MAX_VALUE
        var backY = Int.MAX_VALUE
        when (direct) {
            0 -> {
                backX = x + 1
                backY = y
            }

            1 -> {
                backX = x
                backY = y - 1
            }

            2 -> {
                backX = x - 1
                backY = y
            }

            3 -> {
                backX = x
                backY = y + 1
            }
        }
        return Pair(backX, backY)
    }


    private fun init(N: Int, M: Int, direction: Int) {
        direct = direction
        initDirectionMap()
        map = Array(N) { IntArray(M) }
        visited = Array(N) { BooleanArray(M) { false } }
        for (i: Int in 0 until N) {
            val line = readln().split(" ").map { it.toInt() }
            for (j: Int in 0 until M) {
                map[i][j] = line[j]
            }
        }
    }

    private fun initDirectionMap() {
        //북쪽
        directionMap[0] = Pair(-1, 0)
        //동쪽
        directionMap[1] = Pair(0, 1)
        //남쪽
        directionMap[2] = Pair(1, 0)
        //서쪽
        directionMap[3] = Pair(0, -1)
    }
}