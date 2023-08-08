package backjoon

import common.Solution

class BackJoon_2562: Solution {
    override fun solution() {
        val array = mutableListOf<Int>()
        repeat(9) {
            array.add(readln().toInt())
        }
        val max = array.max()
        for (i: Int in 0 until  array.size) {
            if (array[i] == max) {
                println(array[i])
                println(i + 1)
            }
        }
    }
}