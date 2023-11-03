package src.backjoon

import common.Solution
import java.util.*

class BackJoon_1922: Solution {
    data class NetWork(
        val x: Int,
        val y: Int,
        val cost: Int
    ) : Comparable<NetWork> {
        override fun compareTo(other: NetWork): Int {
            return cost - other.cost
        }
    }

    override fun solution() {
        val V = readln().toInt()
        val M = readln().toInt()
        val networks = PriorityQueue<NetWork>()
        val parent = IntArray(V + 1) { 0 }
        for (i in 1..V) {
            parent[i] = i
        }

        repeat(M) {
            val (x, y, z) = readln().split(" ").map { it.toInt() }
            networks.offer(NetWork(x, y, z))
        }

        var cost = 0
        while (networks.isNotEmpty()) {
            val network = networks.poll()
            if (getParent(parent, network.x) != getParent(parent, network.y)) {
                unionParent(parent, network.x, network.y)
                cost += network.cost
            }
        }
        println(cost)
    }

    fun getParent(parent: IntArray, x: Int): Int {
        if (parent[x] == x) return x
        return getParent(parent, parent[x])
    }

    fun unionParent(parent: IntArray, a: Int, b: Int) {
        val pa = getParent(parent, a)
        val pb = getParent(parent, b)
        if (pa < pb) parent[pb] = pa
        else parent[pa] = pb
    }
}