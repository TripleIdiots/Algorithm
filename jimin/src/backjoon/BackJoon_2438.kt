package backjoon

import common.Solution

class BackJoon_2438: Solution {
    override fun solution() {
        readln().toInt().let {
            for (i: Int in 1 .. it) {
                for (j: Int in 1 .. i) {
                    print("*")
                }
                println()
            }
        }
    }
}