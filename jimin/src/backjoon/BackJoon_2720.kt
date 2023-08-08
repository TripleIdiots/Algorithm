package src.backjoon

import common.Solution

class BackJoon_2720 : Solution {
    override fun solution() {
        val build = StringBuilder()
        repeat(readln().toInt()) {
            var change = readln().toInt()
            val result = mutableListOf<Int>()
            val divisionList = listOf(25, 10, 5, 1)
            for (i: Int in 0 until 4) {
                val div = divisionList[i]
                change = division(change, result, div)
            }
            build.append(result.joinToString(" ")).append("\n")
        }
        println(build)

    }

    private fun division(change: Int, result: MutableList<Int>, div: Int): Int {
        var temp = change
        if (temp.div(div) != 0) {
            result.add(temp / div)
            temp -= temp / div * div
        } else {
            result.add(0)
        }
        return temp
    }
}