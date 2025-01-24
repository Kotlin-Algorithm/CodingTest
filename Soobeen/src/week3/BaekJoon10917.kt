package week3

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val queue: Queue<Int> = LinkedList()
    val distance = Array(n + 1) { -1 }
    val matrix = mutableMapOf<Int, MutableList<Int>>()

    repeat(m) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        matrix[start]?.add(end) ?: matrix.put(start, mutableListOf(end))
    }

    distance[1] = 0
    queue.add(1)

    while (queue.isNotEmpty()) {
        val value = queue.poll()
        matrix[value]
            ?.filter { distance[it] == -1 }
            ?.forEach {
                distance[it] = distance[value] + 1
                queue.add(it)
            }
            ?: continue
    }

    println(distance[n])
}
