package src.backjoon

import common.Solution

class BackJoon_5622 : Solution {
    override fun solution() {
        val map = initMap()
        var seconds = 0
        readln().split("").filter { it.isNotEmpty() }.forEach { read ->
            map.keys.forEach {
                if (it.contains(read)) {
                    seconds += map[it]!!
                }
            }
        }
        println(seconds)
    }

    private fun initMap(): HashMap<String, Int> {
        val map = hashMapOf<String, Int>()
        map["ABC"] = 3
        map["DEF"] = 4
        map["GHI"] = 5
        map["JKL"] = 6
        map["MNO"] = 7
        map["PQRS"] = 8
        map["TUV"] = 9
        map["WXYZ"] = 10
        return map
    }
}