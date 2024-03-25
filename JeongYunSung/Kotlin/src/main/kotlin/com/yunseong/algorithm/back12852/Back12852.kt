package com.yunseong.algorithm.back12852

val dp = HashMap<Int, Pair<Int, Int>>()
var snapshot = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val first = br.readLine().toInt()

    val root = dfs(first, 0)

    var value = first
    var str = ""

    while(dp[value] != null) {
        str += "$value "
        value = dp[value]!!.second
    }
    println("${root}\n${str}1")
}

fun dfs(value: Int, index: Int): Int {
    if (snapshot < index) {
        return snapshot
    }

    if (dp.contains(value) && dp[value]!!.first <= index) {
        return dp[value]!!.first
    }

    if (value == 1) {
        if (snapshot > index) {
            snapshot = index
        }

        return index
    }

    val list = mutableListOf<Pair<Int, Int>>()

    if (value % 3 == 0) {
        val newValue = value / 3
        list.add(dfs(newValue, index + 1) to newValue)
    }

    if (value % 2 == 0) {
        val newValue = value / 2
        list.add(dfs(newValue, index + 1) to newValue)
    }

    if (value > 1) {
        val newValue = value - 1
        list.add(dfs(newValue, index + 1) to newValue)
    }

    val min = list.minBy {
        it.first
    }

    if (!dp.contains(value)) {
        dp[value] = min
    } else {
        if (dp[value]!!.first > min.first) {
            dp[value] = min
        }
    }

    return min.first
}