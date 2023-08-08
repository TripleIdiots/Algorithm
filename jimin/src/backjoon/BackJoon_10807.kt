package backjoon

import common.Solution

class BackJoon_10807: Solution {
    override fun solution() {
        val size = readln().toInt()
        val array = readln().split(" ").map { it.toInt() }.toIntArray()
        val index = readln().toInt()
        if (array.size != size) throw IllegalArgumentException("size error")
        println(array.count {it == index})
    }
}