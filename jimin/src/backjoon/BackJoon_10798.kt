package src.backjoon

import common.Solution

class BackJoon_10798: Solution {
    override fun solution() {
        val colSize = 5
        val map = Array(colSize) { mutableListOf<String>() }
        repeat(colSize) {
            val list = readln().split("").filter { it.isNotBlank() }.toMutableList()
            map[it] = list
        }
        val result = StringBuilder()

        for (i: Int in 0 until 15) {
            for (j: Int in 0 until 15) {
                try {
                    result.append(map[j][i])
                } catch (e: Exception) {
                    continue
                }
            }
        }
        println(result)
    }
}