package backjoon

import common.Solution

class BackJoon_2739: Solution {
    override fun solution() {
        val N = readln().toInt()
        for (i: Int in 1 .. 9) {
            println("$N * $i = ${N*i}")
        }
    }
}