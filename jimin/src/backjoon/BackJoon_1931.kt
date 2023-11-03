package src.backjoon

import common.Solution

class BackJoon_1931: Solution {
    data class Room(
        val start: Int,
        val end: Int
    )
    override fun solution() {
        val n = readln().toInt()
        val rooms = Array(n) { Room(0, 0) }
        repeat(n) {
            val (s, e) = readln().split(" ").map { it.toInt() }
            rooms[it] = Room(s, e)
        }
        //end 순으로 정렬 같다면 start순으로 정렬
        rooms.sortWith(compareBy({it.end}, {it.start}))
        var end = rooms[0].end
        var count = 1
        for (i: Int in 1 until n) {
            //현재 시각이 end보다 작다면 사용가능
            if (rooms[i].start >= end) {
                end = rooms[i].end
                count++
            }
        }
        println(count)
    }
}