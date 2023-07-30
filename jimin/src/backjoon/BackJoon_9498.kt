package backjoon

import common.Solution

class BackJoon_9498: Solution {
    override fun solution() {
        readln().toInt().let {
            when (it) {
                in 90..100 -> print("A")
                in 80.. 89 -> print("B")
                in 70..79 -> print("C")
                in 60..69 -> print("D")
                else -> print("F")
            }
        }
    }
}