package backjoon

import common.Solution
import java.lang.StringBuilder

class BackJoon_15651: Solution {
    var N = -1
    var K = -1
    val list = mutableListOf<Int>()
    val result = StringBuilder()
    override fun solution() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        N = A
        K = B
        for (i: Int in 1..N) {
            list.add(i)
        }
        val numbers = IntArray(K) { 0 }
        create(numbers, 0, 0)
        println(result)
    }
    fun create(temp: IntArray, idx: Int, depth: Int) {
        if (idx == K) {
            result.append(temp.joinToString(" ")).append("\n")
            return
        }

        for (i: Int in 0 until N) {
            temp[idx] = list[i]
            create(temp, idx + 1, depth + 1)
        }
    }
}