package com.yunseong.algorithm.back2156

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val arr = IntArray(n) {
        br.readLine().toInt()
    }

    val dp = IntArray(n) {
        when (it) {
            0 -> arr[0]
            1 -> arr[0] + arr[1]
            2 -> maxOf(arr[0] + arr[2], arr[1] + arr[2], arr[0] + arr[1])
            else -> 0
        }
    }

    for (i in 3 until n) {
        dp[i] = maxOf(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i], dp[i - 1])
    }

    println(dp.max())
}