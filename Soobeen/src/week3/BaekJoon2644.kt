package week3

import java.util.*

fun main() {
    val n = readln().toInt()
    val (node1, node2) = readln().split(" ").map { it.toInt()}
    val m = readln().toInt()
    val queue: Queue<Int> = LinkedList()
    val adj = mutableMapOf<Int, MutableList<Int>>()
    val distance = Array(n + 1) { -1 }

    repeat(m) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        adj[start]?.add(end) ?: adj.put(start, mutableListOf(end))
        adj[end]?.add(start) ?: adj.put(end, mutableListOf(start))
    }

    queue.add(node1)
    distance[node1] = 0

    while(queue.isNotEmpty()) {
        val value = queue.poll()
        adj[value]
            ?.filter { distance[it] == -1 }
            ?.forEach {
                distance[it] = distance[value] + 1
                queue.add(it)
            }
            ?: continue
    }

    println(distance[node2])
}
