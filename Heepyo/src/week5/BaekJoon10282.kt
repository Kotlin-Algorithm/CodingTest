package week5

import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    val t = readln().toInt()

    for (i in 0 until t) {
        val (_, d, c) = readln().split(" ").map(String::toInt)
        val graph: Map<Int, MutableList<Pair<Int, Int>>> = buildMap {
            for (j in 0 until d) {
                val (a, b, s) = readln().split(" ").map(String::toInt)

                computeIfAbsent(b) { mutableListOf<Pair<Int, Int>>() }.add(a to s)
            }
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy(Pair<Int, Int>::second)).apply { offer(c to 0) }
        val visited = mutableSetOf<Int>()
        var last = 0

        while (!pq.isEmpty()) {
            val (current, distance) = pq.poll()

            if (!visited.contains(current)) {
                last = max(last.toDouble(), distance.toDouble()).toInt()
            } else continue
            visited.add(current)
            for ((next, nextDistance) in graph[current] ?: emptyList()) {
                if (visited.contains(next)) continue
                pq.offer(next to distance + nextDistance)
            }
        }
        println(visited.size.toString() + " " + last)
    }
}