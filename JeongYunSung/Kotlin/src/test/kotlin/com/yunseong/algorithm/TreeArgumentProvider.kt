package com.yunseong.algorithm

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.AnnotationConsumer
import java.util.stream.Stream

class TreeArgumentProvider : ArgumentsProvider, AnnotationConsumer<TreeTest> {

    private lateinit var tree: Tree<Any>

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(this.tree)
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun accept(t: TreeTest) {
        val arrays: Array<Any> = if (t.intArray.isNotEmpty()) {
            t.intArray.toTypedArray() as Array<Any>
        } else if (t.stringArray.isNotEmpty()) {
            t.stringArray as Array<Any>
        } else {
            throw IllegalArgumentException("Tree에 넣을 값이 없습니다.")
        }

        val tree: Tree<Any> = Tree()

        arrays.forEach {
            tree.addNode(Node(it))
        }

        this.tree = tree
    }
}
