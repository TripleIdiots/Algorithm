package com.yunseong.algorithm.back2668

import java.util.LinkedList

class Quiz2668 {

    val list = hashMapOf<Vertex2668, LinkedList<Int>>()
    val set = hashMapOf<Vertex2668, Boolean>()

    init {
        val count = readln().toInt()

        for (i in 0 until count) {
            val vertex2668 = Vertex2668(i + 1)
            vertex2668.value = i + 1

            list[vertex2668] = LinkedList<Int>()
        }

        for (i in 0 until count) {
            val value = readln().toInt()
            val index = count + i + 1

            val node2668 = Vertex2668(index)
            node2668.value = value

            list[node2668] = LinkedList<Int>()

            // up -> down
            list[Vertex2668(i + 1)]?.add(index)
            // down -> up
            list[Vertex2668(index)]?.add(value)
        }

        for (i in 0 until count) {
            val first = Vertex2668(i + 1)
            first.value = i + 1
            dfs(first)
        }

        var str: String = set.size.toString()
        set.keys.sortedBy {
            it.value
        }.forEach {
            str += "\n${it.value}"
        }
        println(str)
    }

    fun dfs(first: Vertex2668, start: Vertex2668 = first, visited: HashMap<Vertex2668, Boolean> = hashMapOf()): Boolean {
        if (first == Vertex2668(list[first]?.first ?: -1)) {
            set[first] = true
            return true
        }

        var result = false

        visited[start] = true

        list[start]?.forEach {
            if (list[Vertex2668(it)] == null) {
                return@forEach
            }
            val target = list.keys.first { vertex2668 -> vertex2668.index == it }!!

            if (first == target) {
                return true
            }

            if (visited[target] == null || visited[target] == false) {
                result = dfs(first, target, visited)

                if (result && list.size / 2 < it) {
                    set[target] = true
                }
            }
        }

        return result
    }
}

data class Vertex2668(val index: Int) {
    var value: Int? = null
}

fun main(args: Array<String>) {
    Quiz2668()
}
