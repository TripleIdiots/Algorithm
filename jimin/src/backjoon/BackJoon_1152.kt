package src.backjoon

import common.Solution

class BackJoon_1152 : Solution {
    override fun solution() {
        readln().split(" ").filter { it.isNotBlank() }.also {
            println(it.size)
        }
    }
}