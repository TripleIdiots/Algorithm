package src.backjoon

import common.Solution

class BackJoon_27866 : Solution {
    override fun solution() {
        val str = readln()
        val index = readln().toInt()
        str.split("").filter { it.isNotBlank() }.let {
            println(it[index - 1])
        }
    }
}