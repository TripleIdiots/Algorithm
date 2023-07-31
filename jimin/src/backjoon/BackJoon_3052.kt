package src.backjoon

import common.Solution

class BackJoon_3052: Solution {
    override fun solution() {
        val result = mutableSetOf<Int>()
        repeat(10) {
            result.add(readln().toInt() % 42)
        }
        println(result.size)
    }
}