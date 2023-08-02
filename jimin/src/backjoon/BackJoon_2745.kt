package src.backjoon

import common.Solution
import kotlin.math.pow

class BackJoon_2745 : Solution {
    override fun solution() {
        val initMap = initMap()
        val (B, N) = readln().split(" ")
        val input = B.split("").filter { it.isNotBlank() }
        val n = N.toDouble()
        var result = 0L
        for (i: Int in 0..input.lastIndex) {
            val key = input[i]
            val value = initMap[key]!!
            result += (n.pow(input.lastIndex - i) * value).toLong()
        }
        println(result)
    }

    private fun initMap(): MutableMap<String, Int> {
        val map = mutableMapOf<String, Int>()
        for (i: Int in 0..9) {
            map[i.toString()] = i
        }
        var alphabet = 10
        for (s: Char in 'A'..'Z') {
            map[s.toString()] = alphabet
            alphabet++
        }
        return map
    }
}