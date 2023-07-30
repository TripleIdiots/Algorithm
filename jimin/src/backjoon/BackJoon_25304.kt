package backjoon

import common.Solution

class BackJoon_25304: Solution {
    override fun solution() {
        val totalAmount = readln().toInt()
        var resultAmount = 0
        readln().toInt().let { N ->
            for (i: Int in 0 until N) {
                readln().split(" ").map { it.toInt() }.let { amount ->
                    resultAmount += amount[0] * amount[1]
                }
            }
        }
        when (totalAmount) {
            resultAmount -> print("Yes")
            else -> print("No")
        }
    }
}