package src.backjoon

import common.Solution
import kotlin.math.ceil

class BackJoon_2869: Solution {
    override fun solution() {
        val (A, B, V) = readln().split(" ").map { it.toDouble() }
        println(ceil((V - B) / (A - B)).toInt())
    }
}