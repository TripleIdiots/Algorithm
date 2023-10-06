package com.yunseong.algorithm.findcalf

import java.util.LinkedList

class Problem {

    var answer = 0
    var dis = intArrayOf(1, -1, 5)
    var ch: IntArray? = null
    var queue = LinkedList<Int>()

    fun bfs(s: Int, e: Int): Int {
        ch = IntArray(10001)
        ch!![s] = 1
        queue.offer(s)
        var level = 0
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val x = queue.poll()
                for (j in 0..2) {
                    val nx = x + dis[j]
                    if (nx == e) {
                        return level + 1
                    }
                    if (nx in 1..10000 && ch!![nx] == 0) {
                        ch!![nx] = 1
                        queue.offer(nx)
                    }
                }
            }
            level++
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val p = Problem()
    val s: Int = readln().toInt()
    val e: Int = readln().toInt()
    println(p.bfs(s, e))
}
