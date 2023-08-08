package src.backjoon

import common.Solution

class BackJoon_1193: Solution {
    override fun solution() {
        // 홀수 올라감 // 짝수 내려감
        val x = readln()
        var total = 1
        var i = 1
        while (true) {
            total += i
            if (total > x.toInt()) {
                val gap = total - x.toInt()
                val sum = i + 1
                if (i  % 2 == 0) {
                    println("${sum - gap}/${gap}")
                    break
                } else {
                    println("${gap}/${sum - gap}")
                    break
                }
            }
            i += 1
        }
    }
}