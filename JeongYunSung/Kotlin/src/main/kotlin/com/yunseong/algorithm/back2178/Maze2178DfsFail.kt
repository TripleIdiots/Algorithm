class Maze2178DfsFail {

    private val board: Array<Array<Track2>>
    private val dx = arrayOf(0, 0, 1, -1)
    private val dy = arrayOf(1, -1, 0, 0)

    private val path = mutableListOf<Int>()

    init {
        val inputs = readln().split(" ").map {
            it.toInt()
        }

        board = Array(inputs[0]) {
            readln().toCharArray().map {
                Track2(it.toString().toInt(), false)
            }.toTypedArray()
        }

        dfs(0, 0, 1)

        println(path.min())
    }

    private fun dfs(x: Int, y: Int, depth: Int) {
        if (x < 0 || y < 0 || x >= board.size || y >= board[0].size || board[x][y].visited || board[x][y].data == 0) {
            return
        }

        if (x == board.size - 1 && y == board[0].size - 1) {
            path.add(depth)
            return
        }

        board[x][y].visited = true
        for (i in 0 until 4) {
            dfs(x + dx[i], y + dy[i], depth + 1)
        }
    }
}

class Track2(val data: Int, var visited: Boolean)

fun main(args: Array<String>) {
    Maze2178DfsFail()
}
