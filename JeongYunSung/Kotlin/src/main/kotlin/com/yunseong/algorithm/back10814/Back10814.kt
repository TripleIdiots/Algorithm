package com.yunseong.algorithm.back10814

import java.io.BufferedReader
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    // val queue = Array<Triple<Int, Int, String>?>(n) { null }
    val queue = PriorityQueue<Triple<Int, Int, String>?> { o1, o2 ->
        if (o1!!.first == o2!!.first) o1.second - o2.second
        else {
            o1.first - o2.first
        }
    }

    val br = BufferedReader(System.`in`.reader())

    for (it in 0 until n) {
        val (age, name) = br.readLine().split(" ")
        queue.add(Triple(age.toInt(), it, name))
    }

/*  Array 버전
    queue.sortWith  { o1, o2 ->
        if (o1!!.first == o2!!.first) o1.second - o2.second
        else {
            o1.first - o2.first
        }
    }*/

    val result = StringBuilder()

    for (i in 0 until n) {
        val (age, _, name) = queue.poll()!!
        result.append("$age $name\n")
    }

    print(result.substring(0, result.length - 1))
}