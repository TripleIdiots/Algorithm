package backjoon

import common.Solution

class BackJoon_2588: Solution {
    override fun solution() {
        val input1 = readln().toInt()
        val input2 = readln()
        val temp = input2.split("").filter { it.isNotBlank() }.map { it.toInt() }
        println(input1 * temp[2])
        println(input1 * temp[1])
        println(input1 * temp[0])
        println(input1 * input2.toInt())
    }
}