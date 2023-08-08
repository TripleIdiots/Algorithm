package src.backjoon

import common.Solution

class BackJoon_2675 : Solution {
    override fun solution() {
        val result = StringBuilder()
        repeat(readln().toInt()) {
            val (N, str) = readln().split(" ")
            val latter = str.split("").filter { it.isNotBlank() }
            for (i: Int in latter.indices) {
                for (j: Int in 0 until N.toInt()) {
                    result.append(latter[i])
                }
            }
            result.append("\n")
        }
        println(result)
    }
}