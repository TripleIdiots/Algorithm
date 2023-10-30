package com.yunseong.algorithm.queue

import java.util.LinkedList
import java.util.PriorityQueue

class Dijkstra {

    val graph: Map<Int, LinkedList<Int>> = mapOf(
        0 to LinkedList<Int>().apply { add(1); add(2); },
        1 to LinkedList<Int>().apply { add(0); add(2); add(3) },
        2 to LinkedList<Int>().apply { add(1); add(3); add(4) },
        3 to LinkedList<Int>().apply { add(1); add(2); add(5) },
        4 to LinkedList<Int>().apply { add(2); add(5) },
        5 to LinkedList<Int>().apply { add(3); add(4) }
    )
    val n: Int = graph.size

    fun search() {
        val dist = IntArray(n) { Int.MAX_VALUE }
        val queue = PriorityQueue<Int>()
        queue.add(0)
        dist[0] = 0

        while (queue.isNotEmpty()) {
            val now = queue.poll()

            if (dist[now] < now) continue

            for (next in graph[now]!!) {
                val cost = now + next
                if (cost < dist[next]) {
                    dist[next] = cost
                    queue.add(next)
                }
            }
        }

        for (i in 0 until n) {
            println("$i : ${dist[i]}")
        }
    }
}

fun main(args: Array<String>) {
    Dijkstra().search()
}
