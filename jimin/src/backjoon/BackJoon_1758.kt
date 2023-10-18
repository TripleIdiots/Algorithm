package src.backjoon

import common.Solution

class BackJoon_1758: Solution {
    override fun solution() {
        val N = readln().toInt()
        val tipList = IntArray(N)
        for (i: Int in 0 until N) {
            val tip = readln().toInt()
            tipList[i] = tip
        }
        var total = 0L
        tipList.sortedDescending().forEachIndexed { index, tip ->
            val temp = index + 1
            val isMinus = tip - (temp - 1) < 0
            if (!isMinus) {
                total += tip - (temp - 1)
            }
        }
        println(total)
    }
}