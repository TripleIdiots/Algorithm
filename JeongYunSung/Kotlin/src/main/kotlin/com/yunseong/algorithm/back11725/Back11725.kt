package com.yunseong.algorithm.back11725

import java.io.BufferedReader
import java.util.*
import kotlin.collections.LinkedHashMap

fun main() {
    val br = BufferedReader(System.`in`.reader())

    val n = br.readLine().toInt()

    val tree = LinkedHashMap<Int, LinkedList<Int>>(n)

    repeat(n) {
        tree[it + 1] = LinkedList()
    }

    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        tree[a]!!.add(b)
        tree[b]!!.add(a)
    }

    val visited = BooleanArray(n + 1)
    val parent = IntArray(n + 1)

    val queue: Queue<Int> = LinkedList()
    queue.add(1)

    while(queue.isNotEmpty()) {
        val poll = queue.poll()

        if (visited[poll]) {
            continue
        }

        visited[poll] = true

        for(i in tree[poll]!!) {
            if (!visited[i]) {
                parent[i] = poll
                queue.add(i)
            }
        }
    }

    val answer = StringBuilder()

    for (i in 2 until parent.size) {
        answer.append("${parent[i]}\n")
    }

    print(answer.removeSuffix("\n"))
}