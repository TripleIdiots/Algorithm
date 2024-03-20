package com.yunseong.algorithm.back7562

import java.io.BufferedReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(System.`in`.reader())

    val tc = br.readLine().toInt()
    val dx = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    val answer = StringBuilder()

    for (i in 0 until tc) {
        val l = br.readLine().toInt()
        val (startX, startY) = br.readLine().split(" ").map { it.toInt() }
        val (endX, endY) = br.readLine().split(" ").map { it.toInt() }

        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.add(Triple(startX, startY, 0))

        val visited = Array(l) { BooleanArray(l) }

        while (queue.isNotEmpty()) {
            val (x, y, c) = queue.poll()

            if (visited[x][y]) {
                continue
            }

            if (x == endX && y == endY) {
                answer.append(c).append("\n")
                break
            }

            for (i in 0 until 8) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                visited[x][y] = true

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                    continue
                }

                queue.add(Triple(nx, ny, c + 1))
            }
        }
    }

    print(answer.removeSuffix("\n"))
}