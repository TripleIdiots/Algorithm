package backjoon

import common.Solution

class BackJoon_8393 : Solution {
    override fun solution() {
        val N = readln().toInt()
        var result = 0
        for (i: Int in 1..N) {
            result += i
        }
        print(result)
    }
}