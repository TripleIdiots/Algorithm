package src.backjoon

import common.Solution

class BackJoon_10813: Solution {
    override fun solution() {
        val (N,M) = readln().split(" ").map { it.toInt() }
        val array = mutableListOf<Int>()
        for (i: Int in 1..N) {
            array.add(i)
        }

        for (i: Int in 0 until M) {
            val (a,b) = readln().split(" ").map { it.toInt() }
            val indexA = a - 1
            val indexB = b - 1
            val temp = array[indexA]
            array[indexA] = array[indexB]
            array[indexB] = temp
        }

        println(array.joinToString(" "))
    }
}