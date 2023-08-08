package src.backjoon

import common.Solution

class BackJoon_2908: Solution {
    override fun solution() {
        val build = StringBuilder()
        val result = mutableSetOf<Int>()
        readln()
            .split(" ")
            .map {
                it.split("").filter { it.isNotBlank() }.reversed() }
            .toList()
            .forEach {
                it.forEach {
                    build.append(it)
                }
                result.add(build.toString().toInt())
                build.clear()
            }
        println(result.max())
    }
}