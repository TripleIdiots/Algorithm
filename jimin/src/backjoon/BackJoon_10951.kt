package backjoon

import common.Solution

class BackJoon_10951: Solution {
    override fun solution() {
        while (true) {
            try {
                println(readln().split(" ").sumOf { it.toInt() })
            } catch (e: Exception) {
                break
            }
        }
    }
}