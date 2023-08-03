package src.backjoon

import common.Solution

class BackJoon_5086: Solution {
    override fun solution() {
        while (true) {
            val (A,B) = readln().split(" ").map { it.toInt() }
            when {
                A == 0 && B == 0 -> break
                A < B && B % A == 0 ->  println("factor")
                A > B && A % B == 0 ->  println("multiple")
                else -> println("neither")
            }
        }
    }
}