package src.backjoon

import common.Solution

class BackJoon_15663: Solution {
    var K = -1
    var N = -1
    lateinit var numbers: IntArray
    lateinit var visited: BooleanArray
    lateinit var answer: IntArray
    val result = StringBuilder()
    override fun solution() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
        N = A
        K = B
        answer = IntArray(K)
        visited = BooleanArray(N) { false }
        create(0)
        println(result)
    }

    fun create(index: Int) {
        var before = 0

        if (index == K) {
            result.append(answer.joinToString(" ")).append("\n")
            return
        }
        for (i in numbers.indices) {
            if (!visited[i] && before != numbers[i]) {
                visited[i] = true
                answer[index] = numbers[i]
                before = answer[index]
                create(index + 1)
                visited[i] = false
            }
        }
    }
}