package com.yunseong.algorithm.back1010

import java.math.BigInteger
import java.util.Scanner

class Back1010 {

    val map: HashMap<Int, BigInteger> = HashMap()

    fun solve() {
        val scanner = Scanner(System.`in`)

        val round = scanner.nextLine().toInt()
        var answer = ""

        for (i in 0 until round) {
            val values = scanner.nextLine()
                .split(" ")
                .map {
                    it.toInt()
                }

            answer += (factorial(values[1]) / (factorial(values[0]) * factorial(values[1] - values[0]))).toString() + "\n"
        }

        println(answer)
    }

    fun factorial(n: Int): BigInteger {
        if (n <= 1) {
            return BigInteger.ONE
        }

        val value =
            if (!map.containsKey(n)) {
                val value = BigInteger.valueOf(n.toLong()).multiply(factorial(n - 1))
                map[n] = value
                value
            } else {
                map[n]!!
            }

        return value
    }
}
