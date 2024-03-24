package com.yunseong.algorithm.back1987

val direction = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) { br.readLine().toCharArray() }

    val load = Array(26) { false }
    load[board[0][0] - 'A'] = true

    println(dfs(board, 0, 0, c, load))
}

fun dfs(board: Array<CharArray>, r: Int, c: Int, max: Int, load: Array<Boolean>): Int {
    val list = mutableListOf<Int>()

    for (i in 0 until 4) {
        val (nr, nc) = r + direction[i].first to c + direction[i].second

        if (nr in board.indices && nc in 0 until board[0].size) {
            val index = board[nr][nc] - 'A'

            if (load[index]) continue
            load[index] = true
            list.add(dfs(board, nr, nc, max, load) + 1)
            load[index] = false
        }
    }

    return list.maxOrNull() ?: 1
}