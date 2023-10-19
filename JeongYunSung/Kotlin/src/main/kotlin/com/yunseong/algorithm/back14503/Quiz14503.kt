package com.yunseong.algorithm.back14503

class Quiz14503 {

    private val board: IntArray
    private val direction: IntArray

    var count = 0

    init {
        val (n, m) = readln().split(" ").map { it.toInt() }

        direction = intArrayOf(-m, 1, m, -1) // 북 동 남 서
        board = IntArray(n * m)

        val position = readln().split(" ").map { it.toInt() }

        for (i in 0 until n) {
            val row = readln().split(" ").map { it.toInt() }
            for (j in 0 until m) {
                board[i * m + j] = row[j]
            }
        }

        on(position, m)

        println(count)
    }

    private fun on(position: List<Int>, m: Int) {
        var (r, c, d) = position
        var dir = d

        while (true) {
            if (board[r * m + c] == 0) {
                board[r * m + c] = 2
                count += 1
                continue
            }

            var isMove = false

            for (ds in direction.indices) {
                val index = r * m + c + direction[ds]

                if (isInvalidPosition(index)) {
                    continue
                }

                if (board[r * m + c + direction[ds]] == 0) {
                    dir -= 1
                    if (dir < 0) {
                        dir = 3
                    }
                    d = dir % 4
                    isMove = true
                    break
                }
            }

            if (!isMove) {
                val backward = direction[(d + 2) % 4]
                val index = r * m + c + backward
                if (board[index] == 1) {
                    return
                } else {
                    r = index / m
                    c = index % m
                }
            }

            val forward = direction[d % 4]
            val index = r * m + c + forward

            if (isInvalidPosition(index)) {
                continue
            }

            if (board[index] == 0) {
                r = index / m
                c = index % m
            }
        }
    }

    private fun isInvalidPosition(pos: Int): Boolean {
        return pos < 0 || pos >= board.size
    }
}

fun main(args: Array<String>) {
    Quiz14503()
}
