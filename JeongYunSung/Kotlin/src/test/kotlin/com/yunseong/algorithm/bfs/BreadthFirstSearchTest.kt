package com.yunseong.algorithm.bfs

import com.yunseong.algorithm.Tree
import com.yunseong.algorithm.TreeTest
import com.yunseong.algorithm.algorithm.bfs.BreadthFirstSearch

class BreadthFirstSearchTest {

    @TreeTest(intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20])
    fun `Tree에서 BFS 동작 테스트`(tree: Tree<Int>) {
        tree.search(BreadthFirstSearch())
    }
}
