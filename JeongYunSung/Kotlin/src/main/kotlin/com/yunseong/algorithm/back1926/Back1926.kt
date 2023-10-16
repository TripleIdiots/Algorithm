package com.yunseong.algorithm.back1926

class Back1926 {

    private val board: Array<Array<Element>>
    private val pictures: MutableList<Int> = mutableListOf()

    private val dx = arrayOf(0, 0, -1, 1)
    private val dy = arrayOf(-1, 1, 0, 0)

    init {
        val inputs = readln().split(" ").map {
            it.toInt()
        }

        board = Array(inputs[0]) {
            readln().split(" ").map {
                it.toInt()
            }.map {
                Element(it)
            }.toTypedArray()
        }

        init()
    }

    fun print() {
        println(pictures.size)
        if (pictures.isEmpty()) {
            println(0)
            return
        }
        println(pictures.max())
    }

    private fun init() {
        for (i in board.indices) {
            for (j in board[i].indices) {
                val result = dfs(i, j)
                if (result > 0) {
                    pictures.add(result)
                }
            }
        }
    }

    private fun dfs(x: Int, y: Int): Int {
        if (x < 0 || x >= board.size || y < 0 || y >= board[0].size || board[x][y].visted || board[x][y].value == 0) {
            return 0
        }

        var result = 1

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            board[x][y].visted = true
            result += dfs(nx, ny)
        }

        return result
    }
}

data class Element(val value: Int, var visted: Boolean = false)

fun main(args: Array<String>) {
    Back1926().print()
}
