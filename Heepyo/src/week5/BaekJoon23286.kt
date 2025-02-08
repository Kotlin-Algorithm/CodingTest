package week5

import java.util.PriorityQueue

// TODO 해매고 있음
fun main() {
    val (n, m, t) = readln().split(" ").map(String::toInt)
    val graph = buildMap<Int, MutableList<Pair<Int, Int>>> {
        repeat(m) {
            val (u, v, h) = readln().split(" ").map(String::toInt)

            computeIfAbsent(u) { mutableListOf<Pair<Int, Int>>() }.add(v to h)
        }
    }
    fun dijkstra(start: Int, end: Int): Int {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy(Pair<Int, Int>::second)).apply { offer(start to 0) }
        val visited = mutableSetOf<Int>()
        var answer = 0

        while (!pq.isEmpty()) {
            val (current, value) = pq.poll()

            if (current == end) {
                return value
            }
            visited.add(current)
            for ((next, nextValue) in graph[current] ?: emptyList()) {
                if (!visited.contains(next)) {
                    pq.offer(next to value + nextValue).also { println("test: ${nextValue}") }
                }
            }
        }
        return -1
    }

    for (i in 0 until t) {
        val (s, e) = readln().split(" ").map(String::toInt)

        println(dijkstra(s, e))
    }
    println(graph)
}