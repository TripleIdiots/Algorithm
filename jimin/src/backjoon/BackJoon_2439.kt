package backjoon

import common.Solution

class BackJoon_2439: Solution {
    override fun solution() {
        readln().toInt().let {
            for (i: Int in 1 .. it) {
                for (h: Int in it downTo i + 1) {
                    print(" ")
                }
                for (j: Int in 1 .. i) {
                    print("*")
                }
                println()
            }
        }
    }
}