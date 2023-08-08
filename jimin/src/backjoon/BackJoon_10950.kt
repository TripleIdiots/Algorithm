package backjoon

import common.Solution

class BackJoon_10950 : Solution {
    override fun solution() {
        val N = readln().toInt()
        for (i: Int in 0 until N) {
            readln().split(" ").sumOf { it.toInt() }.also { println(it) }
        }
    }
}