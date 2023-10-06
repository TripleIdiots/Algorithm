package com.yunseong.algorithm.back11399

fun main(args: Array<String>) {
    val target = readln().toInt()
    val list = readln()
        .split(" ")
        .mapIndexed { index, it -> Pair(it.toLong(), index) }
        .sortedBy {
            it.first
        }.onEach {
        }

    var now = 0L
    var temp = 0L
    var result = 0L

    for (i in (0 until target)) {
        now = list[i].first + temp
        temp = now
        result += now
    }

    println(result)
}
