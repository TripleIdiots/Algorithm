package src.backjoon

import common.Solution
import java.lang.StringBuilder

class BackJoon_9086: Solution {
    override fun solution() {
        val testCase = readln().toInt()
        val result = StringBuilder()
        repeat(testCase) {
            val test = readln()
            result.append(test.first()).append(test.last()).append("\n")
        }
        println(result)
    }
}