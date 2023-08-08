package backjoon

import common.Solution

class BackJoon_10871: Solution {
    override fun solution() {
        val (N, X) = readln().split(" ").map { it.toInt() }
        val array = readln().split(" ").map { it.toInt() }.toIntArray()
        array.forEach { value ->
            if (value < X) {
                print("$value ")
            }
        }
    }
}