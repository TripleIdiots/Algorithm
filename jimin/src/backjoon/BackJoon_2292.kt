package src.backjoon

import common.Solution

class BackJoon_2292: Solution {
    override fun solution() {
        var honeycomb = 1L
        var honeycombSize = 6
        val honeycombList = mutableListOf<Long>()
        while (honeycomb < 10000000000) {
            honeycombList.add(honeycomb)
            honeycomb += honeycombSize
            honeycombSize += 6
        }
        val input = readln().toLong()
        var result = 1
        for (i: Int in 0 until honeycombList.size) {
            val comp = honeycombList[i]
            if (comp < input) {
                result++
            } else {
                break
            }
        }
        println(result)
    }
}