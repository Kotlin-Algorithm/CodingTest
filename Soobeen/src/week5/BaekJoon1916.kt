package week5

import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val adj = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distance = IntArray(n + 1) { Int.MAX_VALUE }
    val pQueue: Queue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second }) // current, cost

    repeat(m) {
        val (start, end, cost) = readln().split(" ").map { it.toInt() }
        adj[start].add(end to cost)
    }

    val (start, end) = readln().split(" ").map { it.toInt() }

    distance[start] = 0
    pQueue.add(start to 0)

    while (pQueue.isNotEmpty()) {
        val poll = pQueue.poll()
        val current = poll.first
        val cost = poll.second

        if (distance[current] != cost) continue

        for (pair in adj[current]) {
            val next = pair.first
            val nextCost = pair.second
            if (distance[next] <= distance[current] + nextCost) continue
            distance[next] = distance[current] + nextCost
            pQueue.add(next to distance[next])
        }
    }

    println(distance[end])
}
