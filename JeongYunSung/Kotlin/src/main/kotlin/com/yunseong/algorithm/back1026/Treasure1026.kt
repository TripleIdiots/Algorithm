package com.yunseong.algorithm.back1026

fun main(args: Array<String>) {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.sorted().reversed()
    val b = readln().split(" ").map { it.toInt() }.sorted()

    var result = 0

    for (i in (0 until n)) {
        result += (a[i] * b[i])
    }

    println(result)
}
