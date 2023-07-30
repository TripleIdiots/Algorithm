package backjoon

import common.Solution
import java.time.LocalTime

class BackJoon_2884: Solution {
    override fun solution() {
        readln().split(" ").map { it.toInt() }.let {
            val time = LocalTime.of(it[0], it[1])
            time.minusMinutes(45).let { minusTime ->
                print("${minusTime.hour} ${minusTime.minute}")
            }
        }
    }
}