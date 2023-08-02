package src.backjoon

import common.Solution

class BackJoon_11005 : Solution {
    override fun solution() {
        val initMap = initMap()
        val (B, N) = readln().split(" ").map { it.toLong() }
        val resultList = mutableListOf<String>()
        var division = B / N
        resultList.add(initMap[(B % N).toInt()]!!)
        while (true) {
            if (division != 0L && division != 1L) {
                resultList.add(initMap[(division % N).toInt()]!!)
                division /= N
            } else {
                if (division == 0L) break
                resultList.add(initMap[division.toInt()]!!)
                break
            }
        }
        println(resultList.reversed().joinToString(""))
    }

    private fun initMap(): MutableMap<Int, String> {
        val map = mutableMapOf<Int, String>()
        for (i: Int in 0..9) {
            map[i] = i.toString()
        }
        var alphabet = 10
        for (s: Char in 'A'..'Z') {
            map[alphabet] = s.toString()
            alphabet++
        }
        return map
    }

    private fun easy() {
        val (a,b) =  readln().split(" ").map { it.toInt() }
        println(a.toString(b).uppercase())
    }
}