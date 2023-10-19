package com.yunseong.algorithm.back2669

class Quiz2669 {

    init {
        val arr = Array(100) { BooleanArray(100) { false } }
        var count = 0

        for (i in 0 until 4) {
            val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

            for (x in x1 until x2) {
                for (y in y1 until y2) {
                    if (!arr[y][x]) {
                        arr[y][x] = true
                        count++
                    }
                }
            }
        }

        println(count)
    }
}

fun main(args: Array<String>) {
    Quiz2669()
}
