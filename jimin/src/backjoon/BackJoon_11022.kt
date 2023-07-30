package backjoon

import common.Solution

class BackJoon_11022: Solution {
    override fun solution() {
        readln().toInt().let { N ->
            for (i: Int in 1 .. N) {
                val input = readln().split(" ").map { it.toInt() }
                val sum = input.sum()
                println("Case #$i: ${input[0]} + ${input[1]} = $sum")
            }
        }
    }
}