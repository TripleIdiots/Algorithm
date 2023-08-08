package backjoon

import common.Solution

class BackJoon_11382: Solution {
    override fun solution() {
        readln().split(" ").sumOf { it.toLong() }.also {
            print(it)
        }
    }
}