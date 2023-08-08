package backjoon

import common.Solution

class BackJoon_10810: Solution {
    override fun solution() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val array = IntArray(N)
        repeat(M) {
            val ball = readln().split(" ").map { it.toInt() }
            for (i: Int in ball[0] .. ball[1]) {
                array[i - 1] = ball[2]
            }
        }
        val build = StringBuilder()
        array.forEach {
            build.append(it).append(" ")
        }
        println(build)
    }
}