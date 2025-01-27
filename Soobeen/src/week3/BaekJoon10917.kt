package week3

import java.util.*
import java.util.ArrayDeque

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val queue: Queue<Int> = ArrayDeque()
    val distance = Array(n + 1) { -1 }
    val matrix = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        matrix[start].add(end)
    }

    distance[1] = 0
    queue.add(1)

    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        val list = matrix[currentNode]
        for (index in list) {
            if (distance[index] == -1) {
                distance[index] = distance[currentNode] + 1
                queue.add(index)
            }
        }
    }

    println(distance[n])
}
