package com.yunseong.algorithm.back1931

fun main(args: Array<String>) {
    val c = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until c) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }

    list.sortWith { a, b ->
        if (a.second == b.second) {
            a.first - b.first
        } else {
            a.second - b.second
        }
    }

    var count = 0
    var end = 0

    for (i in 0 until c) {
        val (a, b) = list[i]

        if (a >= end) {
            count++
            end = b
        }
    }

    println(count)
}