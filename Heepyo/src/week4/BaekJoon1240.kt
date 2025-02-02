package week4

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = buildMap<Int, ArrayList<Pair<Int, Int>>> {
        repeat(n - 1) {
            val (a, b, weight) = readln().split(" ").map(String::toInt)

            computeIfAbsent(a) { _ -> ArrayList<Pair<Int, Int>>() }.add(b to weight)
            computeIfAbsent(b) { _ -> ArrayList<Pair<Int, Int>>() }.add(a to weight)
        }
    }

    for (i in 0 until m) {
        val (s, e) = readln().split(" ").map(String::toInt)

        println(bfs(start = s, end = e, graph))
    }
}

fun bfs(start: Int, end: Int, graph: Map<Int, ArrayList<Pair<Int, Int>>>): Int {
    val queue = ArrayDeque(listOf(start to 0))
    val visited = mutableSetOf<Int>()

    while (!queue.isEmpty()) {
        val (current, sumOfWeight) = queue.poll()

        if (current == end) return sumOfWeight
        visited.add(current)
        for ((next, weight) in graph[current] ?: emptyList()) {
            if (!visited.contains(next)) {
                queue.offer(next to sumOfWeight + weight)
            }
        }
    }
    return 0
}