package com.yunseong.algorithm.graph

import com.yunseong.algorithm.Element
import com.yunseong.algorithm.Search
import java.util.LinkedList

class Graph<T> : Element {

    private val adjacencyMap = hashMapOf<Vertex<T>, LinkedList<Edge<T>>>()

    fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex<T>(adjacencyMap.count())
        vertex.data = data
        adjacencyMap[vertex] = LinkedList()
        return vertex
    }

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>) {
        val edge = Edge(source, destination)
        adjacencyMap[source]?.add(edge)
    }

    fun from(index: Int): Vertex<T> {
        return adjacencyMap.keys.firstOrNull {
            it.index == index
        } ?: throw NoSuchElementException()
    }

    operator fun get(vertex: Vertex<T>): LinkedList<Edge<T>>? {
        return adjacencyMap[vertex]
    }

    override fun search(search: Search) {
        search.search(this)
    }

    override fun toString(): String {
        return buildString {
            adjacencyMap.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.data.toString() }
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }
}
