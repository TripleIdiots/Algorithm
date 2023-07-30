package backjoon

import common.Solution

class BackJoon_10952: Solution {
    override fun solution() {
        while (true) {
            val input = readln().split(" ").map { it.toInt() }
            if (input[0] == 0 && input[1] == 0) {
                break
            }
            println(input.sum())
        }
    }
}