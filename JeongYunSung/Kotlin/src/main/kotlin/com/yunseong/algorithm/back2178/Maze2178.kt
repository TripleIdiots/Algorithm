import java.util.LinkedList

class Maze2178 {

    private val board: Array<Array<Track>>
    private val dx = arrayOf(0, 0, 1, -1)
    private val dy = arrayOf(1, -1, 0, 0)

    init {
        val inputs = readln().split(" ").map {
            it.toInt()
        }

        board = Array(inputs[0]) { y ->
            var x = 0
            readln().toCharArray().map {
                Track(y, x++, it.toString().toInt(), false)
            }.toTypedArray()
        }

        println(bfs(0, 0))
    }

    private fun bfs(x: Int, y: Int): Int {
        val queue = LinkedList<Pair<Int, Track>>()

        if (board[y][x].data == 0) {
            return 0
        }

        queue.add(1 to board[y][x])
        board[y][x].visited = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()

            if (node.second.y == board.size - 1 && node.second.x == board[0].size - 1) {
                return node.first
            }

            for (i in 0 until 4) {
                val nx = node.second.x + dx[i]
                val ny = node.second.y + dy[i]

                if (nx < 0 || nx >= board[0].size || ny < 0 || ny >= board.size || board[ny][nx].visited || board[ny][nx].data == 0) {
                    continue
                }

                queue.add(node.first + 1 to board[ny][nx])
                board[ny][nx].visited = true
            }
        }

        return 0
    }
}

class Track(val y: Int, val x: Int, val data: Int, var visited: Boolean)

fun main(args: Array<String>) {
    Maze2178()
}
