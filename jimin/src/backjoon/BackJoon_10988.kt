package src.backjoon

import common.Solution

class BackJoon_10988: Solution {
    override fun solution() {
        readln().let {
            val reversed = it.reversed()
            if (it == reversed) {
                println("1")
            } else {
                println("0")
            }
        }
    }
}