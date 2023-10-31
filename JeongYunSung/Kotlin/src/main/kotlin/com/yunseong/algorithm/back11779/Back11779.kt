package com.yunseong.algorithm.back11779

import java.util.LinkedList
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val vertex = readln().toInt()
    val edge = readln().toInt()

    val graph = hashMapOf(*(0..vertex).map {
        it to LinkedList<MyEdge>()
    }.toTypedArray())

    for (i in 0..<edge) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u]!!.add(MyEdge(v, w))
    }

    val (start, end) = readln().split(" ").map { it.toInt() }

    val dist = IntArray(vertex + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<MyEdge> { o1, o2 -> o1.w - o2.w }
    val visited = BooleanArray(vertex + 1)
    val firstEdge = MyEdge(start, 0)
    pq.add(firstEdge)
    dist[start] = 0

    var lastEdge: MyEdge? = firstEdge

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (visited[cur.v]) {
            continue
        }

        visited[cur.v] = true
        for (i in graph[cur.v]!!) {
            val cost = cur.w + i.w
            if (dist[i.v] > cost) {
                dist[i.v] = cost
                i.before = cur
                pq.add(MyEdge(i.v, cost, i.before))

                if (i.v == end) {
                    lastEdge = i
                }
            }
        }
    }

    val stringBuffer = StringBuffer()
    val countArray = IntArray(1)
    createText(stringBuffer, lastEdge, countArray)

    println("${dist[end]}\n${countArray[0]}\n$stringBuffer")
}

fun createText(stringBuffer: StringBuffer, edge: MyEdge?, array: IntArray) {
    if (edge == null) {
        return
    }

    createText(stringBuffer, edge.before, array)
    array[0] += 1
    stringBuffer.append("${edge.v} ")
}

data class MyEdge(val v: Int, val w: Int, var before: MyEdge? = null)