package com.yunseong.algorithm

import com.yunseong.algorithm.graph.Graph
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.support.AnnotationConsumer
import java.util.stream.Stream

class GraphArgumentProvider : ArgumentsProvider, AnnotationConsumer<GraphTest> {

    private lateinit var graph: Graph<Any>

    override fun provideArguments(p0: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.of(this.graph)
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun accept(t: GraphTest) {
        val arrays: Array<Any> = if (t.intArray.isNotEmpty()) {
            t.intArray.toTypedArray() as Array<Any>
        } else if (t.stringArray.isNotEmpty()) {
            t.stringArray as Array<Any>
        } else {
            throw IllegalArgumentException("Tree에 넣을 값이 없습니다.")
        }

        val graph = Graph<Any>()

        arrays.forEach {
            graph.createVertex(it)
        }

        this.graph = graph
    }
}
