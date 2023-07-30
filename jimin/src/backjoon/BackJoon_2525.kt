package backjoon

import common.Solution
import java.time.LocalTime

class BackJoon_2525: Solution {
    override fun solution() {
        val currentTime = readln().split(" ").map { it.toInt() }.let { LocalTime.of(it[0],it[1]) }
        val setTime = readln().toLong()
        currentTime.plusMinutes(setTime).let {
            print("${it.hour} ${it.minute}")
        }
    }
}