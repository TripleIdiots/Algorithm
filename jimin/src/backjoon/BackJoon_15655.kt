package src.backjoon

import common.Solution

class BackJoon_15655: Solution {
    var K = -1
    var N = -1
    lateinit var numbers: IntArray
    lateinit var answer: IntArray
    val result = StringBuilder()
    override fun solution() {
        val(A,B) = readln().split(" ").map { it.toInt() }
        N = A
        K = B
        numbers = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
        answer = IntArray(K)
        create(0, 0)
        print(result)
    }

    fun create(index: Int, depth: Int) {
        if (index == K) {
            result.append(answer.joinToString(" ")).append("\n")
            return
        }
        for (i: Int in depth until N) {
            answer[index] = numbers[i]
            create(index + 1, i + 1)
        }
    }
}