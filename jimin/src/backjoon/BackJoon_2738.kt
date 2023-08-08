package src.backjoon

import common.Solution

class BackJoon_2738: Solution {
    override fun solution() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val list1 = mutableListOf<IntArray>()
        val list2 = mutableListOf<IntArray>()
        val result = mutableListOf<IntArray>()
        repeat(N * 2) {
            if (it < N) {
                list1.add(readln().split(" ").map { it.toInt() }.toIntArray())
            } else {
                list2.add(readln().split(" ").map { it.toInt() }.toIntArray())
            }
        }

        for (i: Int in 0 until N) {
            val innerResult = IntArray(M)
            for (j: Int in 0 until M) {
                innerResult[j] = list1[i][j] + list2[i][j]
            }
            result.add(innerResult)
        }

        result.forEach {
            println(it.joinToString(" "))
        }
    }
}