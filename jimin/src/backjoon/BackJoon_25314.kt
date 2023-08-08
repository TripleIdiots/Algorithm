package backjoon

import common.Solution

class BackJoon_25314 : Solution {
    override fun solution() {
        readln().toInt().let {
            val result = StringBuilder()
            val N = it / 4
            for (i: Int in 0 until N) {
                result.append("long ")
            }
            result.append("int")
            print(result)
        }
    }
}