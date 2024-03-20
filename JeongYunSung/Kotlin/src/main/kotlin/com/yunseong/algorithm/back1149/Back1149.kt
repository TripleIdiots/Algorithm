package com.yunseong.algorithm.back1149

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(n) { IntArray(3) }

    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][2]

    for (i in 1 until n) {
        dp[i][0] = arr[i][0] + dp[i - 1][1].coerceAtMost(dp[i - 1][2])
        dp[i][1] = arr[i][1] + dp[i - 1][0].coerceAtMost(dp[i - 1][2])
        dp[i][2] = arr[i][2] + dp[i - 1][0].coerceAtMost(dp[i - 1][1])
    }

    println(dp[n - 1].minOf { it })
}