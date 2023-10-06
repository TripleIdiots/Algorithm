package com.yunseong.algorithm.back1260

import java.util.LinkedList
import java.util.Scanner

class Graph1260 {

    private val graph = mutableMapOf<Int, MutableList<Int>>()

    fun addVertex(vertex: Int) {
        graph[vertex] = mutableListOf()
    }

    fun addEdge(vertex1: Int, vertex2: Int) {
        graph[vertex1]?.add(vertex2)
        graph[vertex2]?.add(vertex1)
    }

    fun dfs(x: Int) {
        this.graph.keys.forEach {
            this.graph[it]?.sort()
        }
        val str = StringBuilder()
        internalDfs(x, str)
        print(str)
    }

    fun bfs(x: Int) {
        this.graph.keys.forEach {
            this.graph[it]?.sort()
        }
        internalBfs(x)
    }

    private fun internalDfs(x: Int, answer: StringBuilder, visited: MutableList<Int> = mutableListOf()) {
        answer.append("$x ")
        visited.add(x)

        graph[x]?.forEach {
            if (!visited.contains(it)) {
                internalDfs(it, answer, visited)
            }
        }
    }

    private fun internalBfs(x: Int) {
        var answer = ""

        val queue = LinkedList<Int>()

        queue.add(x)
        val visited = mutableListOf<Int>()
        visited.add(x)

        while (queue.isNotEmpty()) {
            val value = queue.pollLast()
            answer += "$value "

            graph[value]?.forEach {
                if (!visited.contains(it)) {
                    queue.push(it)
                    visited.add(it)
                }
            }
        }

        print(answer)
    }

    fun solve() {
        Scanner(System.`in`).use {
            val r = it.nextLine().split(" ").map { e ->
                e.toInt()
            }

            val graph = Graph1260()

            (0 until r[0]).forEach { e ->
                graph.addVertex(e + 1)
            }

            (0 until r[1]).forEach { _ ->
                it.nextLine().split(" ").map { e ->
                    e.toInt()
                }.let { e ->
                    graph.addEdge(e[0], e[1])
                }
            }

            graph.dfs(r[2])
            println()
            graph.bfs(r[2])
        }
    }
}

fun main(args: Array<String>) {
    val problem = Graph1260()
    problem.solve()
}
