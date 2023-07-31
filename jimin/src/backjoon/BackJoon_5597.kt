package src.backjoon

import common.Solution

class BackJoon_5597: Solution {
    override fun solution() {
        val totalList = mutableListOf<Int>()
        val summitList = mutableListOf<Int>()
        for (i: Int in 1 .. 30) {
            totalList.add(i)
        }

        for (i:Int in 0 until 28) {
            summitList.add(readln().toInt())
        }

        totalList
            .filter { !summitList.contains(it) }
            .sorted()
            .forEach {
                println(it)
            }
    }
}