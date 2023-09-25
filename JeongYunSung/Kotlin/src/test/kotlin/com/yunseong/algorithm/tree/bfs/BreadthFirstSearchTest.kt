package com.yunseong.algorithm.tree.bfs

import com.yunseong.algorithm.tree.Tree
import com.yunseong.algorithm.tree.TreeTest

class BreadthFirstSearchTest {

    @TreeTest(intArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20])
    fun `BFS 동작 테스트`(tree: Tree<Int>) {
        // given
        tree.search = BreadthFirstSearch()

        // when
        tree.search()

        // then
    }
}
