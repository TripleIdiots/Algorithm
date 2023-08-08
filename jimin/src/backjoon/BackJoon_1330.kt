package backjoon

import common.Solution

class BackJoon_1330: Solution {
    override fun solution() {
        readln().split(" ").map { it.toInt() }.let {input ->
            val A = input[0]
            val B = input[1]
            when {
                A < B -> print("<")
                A > B -> print(">")
                A == B -> print("==")
            }
        }
    }
}