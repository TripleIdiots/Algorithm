package src.backjoon

import common.Solution

class BackJoon_3003: Solution {
    override fun solution() {
        val init = mutableListOf<Int>()
        init.add(1)
        init.add(1)
        init.add(2)
        init.add(2)
        init.add(2)
        init.add(8)

        val result = StringBuilder()
        readln().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            init[index] = init[index] - i
        }
        println(init.joinToString(" "))
    }
}