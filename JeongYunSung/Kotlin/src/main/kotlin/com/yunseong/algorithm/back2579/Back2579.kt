package com.yunseong.algorithm.back2579

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stairs = IntArray(n) {
        br.readLine().toInt()
    }

    val dp = IntArray(n) {
        when(it) {
            0 -> stairs[0]
            1 -> stairs[0] + stairs[1]
            2 -> maxOf(stairs[0], stairs[1]) + stairs[2]
            else -> 0
        }
    }

    for(i in 3 until n) {
        dp[i] = maxOf(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i])
    }

    println(dp[n - 1])
}