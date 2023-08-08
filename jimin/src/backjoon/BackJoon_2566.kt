package src.backjoon

import common.Solution

class BackJoon_2566: Solution {
    override fun solution() {
        val colSize = 9
        val rowSize = 9
        val map = MutableList(colSize) { IntArray(rowSize) }
        repeat(colSize) {
            val col = readln().split(" ").map { it.toInt() }.toIntArray()
            map[it] = col
        }
        val max = map.maxBy { it.max() }.max()
        map.forEachIndexed { colIndex, ints ->
            ints.forEachIndexed { rowIndex, i ->
                if (i == max) {
                    println(max)
                    println("${colIndex + 1} ${rowIndex + 1}")
                    return
                }
            }
        }
    }
}