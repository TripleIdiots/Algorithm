package src.programmers

import common.Solution
import java.math.BigInteger

class 피보나치_수: Solution {
    private val dp = Array<BigInteger>(100001) { BigInteger.ZERO }
    override fun solution() {
        init()
        val n = readln().toInt()
        pibo(n)
        println(dp[n].remainder((1234567).toBigInteger()).toInt())
    }

    private fun init() {
        dp[0] = BigInteger.ZERO
        dp[1] = BigInteger.ONE
        dp[2] = BigInteger.ONE
    }

    private fun pibo(n: Int): BigInteger {
        if (n <= 2) return dp[n]
        if (dp[n] != BigInteger.ZERO) return dp[n]
        dp[n] = pibo(n - 1) + pibo(n - 2)
        return dp[n]
    }
}