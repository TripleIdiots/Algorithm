package src.backjoon

import common.Solution

class BackJoon_11653: Solution {
    override fun solution() {
        val input = readln().toInt()
        val result = factorization(input)
        println(result.joinToString(" \n"))
    }

    private fun factorization(factor: Int): List<Int> {
        val factorizationList = mutableListOf<Int>()
        var minFactor = 2
        var temp = factor
        while (temp != 1) {
            if (temp % minFactor == 0) {
                temp /= minFactor
                factorizationList.add(minFactor)
            } else {
                minFactor++
            }
        }
        return factorizationList.sorted()
    }
}