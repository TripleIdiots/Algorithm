package com.yunseong.algorithm.queue

import java.util.PriorityQueue

fun main(args: Array<String>) {
    val priorityQueue = PriorityQueue<Int>() {
            o1, o2 ->
        o2 - o1
    }

    priorityQueue.add(1)
    priorityQueue.add(2)
    priorityQueue.add(7)
    priorityQueue.add(4)
    priorityQueue.add(5)
    priorityQueue.add(6)

    println(priorityQueue.poll())
}
