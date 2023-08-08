package src.backjoon

import common.Solution

class BackJoon_10811: Solution {
    override fun solution() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val result = mutableListOf<Int>()
        repeat(N) {
            result.add(it + 1)
        }

        for(i in 0 until M) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            if (a == b) continue
            result.subList(a - 1, b).reverse()
        }
        println(result.joinToString(" "))
    }
}