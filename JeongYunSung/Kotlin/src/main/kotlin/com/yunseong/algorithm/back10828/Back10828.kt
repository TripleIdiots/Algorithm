package com.yunseong.algorithm.back10828

import java.io.BufferedReader
import java.util.*

fun main() {
    val br = BufferedReader(System.`in`.reader())
    val stack = LinkedList<Int>()

    val n = br.readLine().toInt()
    val answer = StringBuilder()

    repeat(n) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "push" -> stack.push(input[1].toInt())
            "pop" -> answer.append("${if (stack.isEmpty()) -1 else stack.pop()}\n")
            "size" -> answer.append("${stack.size}\n")
            "empty" -> answer.append("${if (stack.isEmpty()) 1 else 0}\n")
            "top" -> answer.append("${if (stack.isEmpty()) -1 else stack.peek()}\n")
        }
    }

    print(answer.removeSuffix("\n"))
}