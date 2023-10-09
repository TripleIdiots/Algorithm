package backjoon

import common.Solution
import java.lang.StringBuilder

class BackJoon_15654: Solution {
    var N = -1
    var K = -1
    val list = mutableListOf<Int>()
    val result = StringBuilder()
    fun create(temp: IntArray, idx: Int, visited: BooleanArray) {
        if (idx == K) {
            result.append(temp.joinToString(" ")).append("\n")
            return
        }

        for (i: Int in 0 until N) {
            if (!visited[i]) {
                visited[i] = true
                temp[idx] = list[i]
                create(temp, idx + 1, visited)
                visited[i] = false
            }
        }
    }
    override fun solution() {
        val (A, B) = readln().split(" ").map { it.toInt() }
        val inputs = readln().split(" ").map { it.toInt() }
        N = A
        K = B
        for (i: Int in 0 until N) {
            list.add(inputs[i])
        }
        list.sort()
        val numbers = IntArray(K) { 0 }
        val visited = BooleanArray(N) {false}
        create(numbers, 0, visited)
        println(result)
    }
}