package com.yunseong.algorithm.back2667

class Quiz2667 {

    private val board: Array<Array<Home>>
    private val dx = arrayOf(0, 0, 1, -1)
    private val dy = arrayOf(1, -1, 0, 0)

    init {
        val inputs = readln().split(" ").map {
            it.toInt()
        }

        board = Array(inputs[0]) {
            readln().toCharArray().map {
                Home(it.toString().toInt(), false)
            }.toTypedArray()
        }

        val list = mutableListOf<Int>()

        for (i in board.indices) {
            for (j in board.indices) {
                val element = dfs(i, j)
                if (element > 0)
                    list.add(element)
            }
        }

        list.sort()

        println(list.size)
        list.forEach {
            println(it)
        }
    }

    fun dfs(x:Int, y: Int): Int {
        if (x < 0 || x >= board.size || y < 0 || y >= board.size || board[y][x].visited || board[y][x].data == 0) {
            return 0
        }

        var result = board[y][x].data
        board[y][x].visited = true

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            result += dfs(nx, ny)
        }
        return result
    }
}

class Home(val data: Int, var visited: Boolean)

fun main(args: Array<String>) {
    Quiz2667()
}
