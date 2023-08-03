package src.backjoon

import common.Solution
import kotlin.math.pow

class BackJoon_2903: Solution {
    override fun solution() {
        var initSize = 2
        var mul = 1
        val input = readln().toInt()

        if (input != 1) {
            for (i: Int in 1..input) {
                initSize += mul
                mul *= 2
            }
        } else {
            initSize += 1
        }
        println(initSize.toDouble().pow(2).toInt())
    }
}