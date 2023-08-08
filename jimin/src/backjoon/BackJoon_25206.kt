package src.backjoon

import common.Solution
import java.text.DecimalFormat

class BackJoon_25206 : Solution {
    override fun solution() {
        val N = 20
        var totalScore: Float = 0.0f
        var result: Float = 0.0f
        repeat(N) {
            val (subject, score, grade) = readln().split(" ")
            if (grade != "P") {
                val temp = score.toFloat()
                totalScore += temp
                when (grade) {
                    "A+" -> result += temp * 4.5f
                    "A0" -> result += temp * 4.0f
                    "B+" -> result += temp * 3.5f
                    "B0" -> result += temp * 3.0f
                    "C+" -> result += temp * 2.5f
                    "C0" -> result += temp * 2.0f
                    "D+" -> result += temp * 1.5f
                    "D0" -> result += temp * 1.0f
                    "F" -> result += temp * 0.0f
                }
            }
        }
        println(roundFormat(result.div(totalScore), "0.000000"))
    }

    private fun <T> roundFormat(value: T, pattern: String): String {
        val df = DecimalFormat(pattern)
        return df.format(value)
    }
}