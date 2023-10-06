package com.yunseong.algorithm.algorithm.bfs

import java.util.LinkedList

class TreeBFS {

    var root: Node? = null

    class Node(
        val data: Int
    ) {

        var lt: Node? = null
        var rt: Node? = null
    }

    fun bfs(node: Node): Int {
        val queue = LinkedList<Node>()
        queue.offer(node)
        var level = 0

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.poll()
                if (cur.lt == null && cur.rt == null) return level
                if (cur.lt != null) queue.offer(cur.lt)
                if (cur.rt != null) queue.offer(cur.rt)
            }
            level++
        }

        return 0
    }
}

fun main(args: Array<String>) {
    val tree = TreeBFS()
    tree.root = TreeBFS.Node(1)
    tree.root!!.lt = TreeBFS.Node(2)
    tree.root!!.rt = TreeBFS.Node(3)
    tree.root!!.lt!!.lt = TreeBFS.Node(4)
    tree.root!!.lt!!.rt = TreeBFS.Node(5)

    println(tree.bfs(tree.root!!))
}
