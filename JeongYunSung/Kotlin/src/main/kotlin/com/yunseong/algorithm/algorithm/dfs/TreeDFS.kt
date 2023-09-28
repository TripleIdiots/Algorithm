package com.yunseong.algorithm.algorithm.dfs

class TreeDFS {

    var root: Node? = null

    fun dfs(l: Int, root: Node): Int {
        if (root.lt == null && root.rt == null) return l
        else return Math.min(dfs(l+1, root.lt!!), dfs(l+1, root.rt!!))

        return 0
    }

    class Node(
        val data: Int
    ) {

        var lt: Node? = null;
        var rt: Node? = null;
    }
}

fun main(args: Array<String>) {
    val tree = TreeDFS()
    tree.root = TreeDFS.Node(1)
    tree.root!!.lt = TreeDFS.Node(2)
    tree.root!!.rt = TreeDFS.Node(3)
    tree.root!!.lt!!.lt = TreeDFS.Node(4)
    tree.root!!.lt!!.rt = TreeDFS.Node(5)

    println(tree.dfs(0, tree.root!!))
}