package backjoon

import common.Solution

class BackJoon_11021: Solution {
    override fun solution() {
        readln().toInt().let { N ->
            for (i: Int in 1 .. N) {
                val sum = readln().split(" ").sumOf { it.toInt() }
                println("Case #$i: $sum")
            }
        }
    }
}