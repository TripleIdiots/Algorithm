package src.programmers

import common.Solution

class `로또의-최고순위와-최저순위` : Solution {
    override fun solution() {
        var lottos = listOf(44, 1, 0, 0, 31, 25).toIntArray()
        var win_nums = listOf(31, 10, 45, 1, 6, 19).toIntArray()
        winnerMatch(
            lottos = lottos,
            win_nums = win_nums
        ).toPrint()
    }

    private fun winnerMatch(lottos: IntArray, win_nums: IntArray): IntArray {
        val case1 = BooleanArray(6)
        val case2 = BooleanArray(6)
        lottos.sort()
        win_nums.sort()
        lottos.forEachIndexed { index, i ->
            if (i == 0) {
                case1[index] = true
                case2[index] = false
            } else {
                case1[index] = win_nums.contains(i)
                case2[index] = win_nums.contains(i)
            }
        }
        return getRankings(case1, case2)
    }

    private fun getRankings(vararg cases: BooleanArray): IntArray {
        val returns = MutableList(cases.size) { 0 }.toIntArray()
        cases.forEachIndexed { index, booleans ->
            returns[index] = getRanking(booleans)
        }
        return returns
    }

    private fun getRanking(case: BooleanArray): Int {
        when (case.filter { it }.size) {
            0, 1 -> return 6
            2 -> return 5
            3 -> return 4
            4 -> return 3
            5 -> return 2
            6 -> return 1
            else -> return 0
        }
    }

    private fun IntArray.toPrint() = println(this.joinToString(","))
}