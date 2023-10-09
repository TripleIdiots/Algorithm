package src.backjoon

import common.Solution

class BackJoon_15650: Solution {
    var K = -1
    var N = -1
    lateinit var numbers: IntArray
    lateinit var answer: IntArray
    val result = StringBuilder()
    override fun solution() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        N = A
        K = B
        numbers = IntArray(N)
        answer = IntArray(K)
        for (i: Int in 1..N) {
            numbers[i - 1] = i
        }
        create(0, 0)
        println(result)
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