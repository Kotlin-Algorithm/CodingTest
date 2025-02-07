package week3

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = buildMap<Int, MutableList<Int>> {
        for (i in 0 until m) {
            val (x, y) = readln().split(" ").map(String::toInt)

            computeIfAbsent(x) { _ -> mutableListOf() }.add(y)
        }
    }
    val queue = LinkedList(listOf(1 to 0))
    val visited = mutableSetOf(1)

    while (!queue.isEmpty()) {
        val (current, level) = queue.poll()

        if (current == n) {
            println(level)
            return
        }
        for (next in graph[current] ?: emptyList()) {
            if (!visited.contains(next) && current < next) {
                visited.add(next)
                queue.offer(next to level + 1)
            }
        }
    }
    println(-1)
}