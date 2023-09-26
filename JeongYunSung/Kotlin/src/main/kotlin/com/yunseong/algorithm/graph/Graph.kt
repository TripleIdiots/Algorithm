package com.yunseong.algorithm.graph

class Graph<T> {

    private val adjacencyMap = mutableMapOf<Vertex<T>, ArrayList<Edge<T>>>()

    fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencyMap.count(), data)
        adjacencyMap[vertex] = arrayListOf()
        return vertex
    }

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>) {
        val edge = Edge(source, destination)
        adjacencyMap[source]?.add(edge)
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
