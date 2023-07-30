package backjoon

import common.Solution

class BackJoon_10430 : Solution {
    override fun solution() {
        readln().split(" ").map { it.toInt() }.let { input ->
            val a = input[0]
            val b = input[1]
            val c = input[2]
            println((a + b) % c)
            println(((a % c) + (b % c)) % c)
            println((a * b) % c)
            println(((a % c) * (b % c)) % c)
        }
    }
}