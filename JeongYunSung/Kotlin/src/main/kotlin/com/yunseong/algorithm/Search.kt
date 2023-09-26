package com.yunseong.algorithm

import com.yunseong.algorithm.graph.Graph
import com.yunseong.algorithm.tree.Tree

interface Search {

    fun <T> search(tree: Tree<T>)

    fun <T> search(graph: Graph<T>)
}
