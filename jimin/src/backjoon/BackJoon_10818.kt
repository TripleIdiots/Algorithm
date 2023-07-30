package backjoon

import common.Solution

class BackJoon_10818: Solution {
    override fun solution() {
        val N = readln().toInt()
        val array = readln().split(" ").map { it.toInt() }.toIntArray()
        println("${array.min()} ${array.max()}")
    }
}