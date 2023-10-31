package com.yunseong.algorithm.back11657

lateinit var distance: Array<Long>
lateinit var bus: Array<Triple<Int, Int, Int>>
var bn = 0
var bm = 0

fun main(args: Array<String>) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    bn = n
    bm = m

    distance = Array(n + 1) { Long.MAX_VALUE }
    bus = Array(m) { Triple(0, 0, 0) }

    for (i in 0 until m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        bus[i] = Triple(a, b, c)
    }

    if (bellmanFord(1)) {
        println(-1)
    } else {
        for (i in 2..n) {
            if (distance[i] == Long.MAX_VALUE) {
                println(-1)
            } else {
                println(distance[i])
            }
        }
    }
}

fun bellmanFord(start: Int): Boolean {
    distance[start] = 0

    for (i in 1 until bn) {
        for (j in 0 until bm) {
            val targetBus = bus[j]

            if (distance[targetBus.first] == Long.MAX_VALUE) continue

            if (distance[targetBus.second] > distance[targetBus.first] + targetBus.third) {
                distance[targetBus.second] = distance[targetBus.first] + targetBus.third
            }
        }
    }

    for (i in 0 until bm) {
        val targetBus = bus[i]

        if (distance[targetBus.first] == Long.MAX_VALUE) continue

        if (distance[targetBus.second] > distance[targetBus.first] + targetBus.third) {
            return true
        }
    }
    return false
}
