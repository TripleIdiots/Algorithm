package backjoon

import common.Solution

class BackJoon_2753: Solution {
    override fun solution() {
        readln().toInt().let {
            when {
                it % 4 == 0 && (it % 100 != 0 || it % 400 == 0) -> print("1")
                else -> print("0")
            }
        }
    }
}