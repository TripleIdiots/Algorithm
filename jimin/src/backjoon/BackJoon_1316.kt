package src.backjoon

import common.Solution

class BackJoon_1316 : Solution {
    override fun solution() {
        val n = readln().toInt()
        var result = 0
        repeat(n) {
            var isCheck = true
            val input = readln().split("").filter { it.isNotBlank() }
            val history = mutableListOf<String>()
            input.forEach {
                if (history.size > 0 && it == history[history.lastIndex]) {
                    return@forEach
                } else {
                    if (history.contains(it)) {
                        isCheck = false
                        return@repeat
                    }
                }
                history.add(it)
            }
            if (isCheck) {
                result += 1
            }
        }
        println(result)
    }
}