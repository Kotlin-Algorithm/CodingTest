package week4

import java.util.*

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val pQueue: Queue<Pair<Int, Int>> = PriorityQueue(compareBy { it.first }) // 거리, 정점
    val distanceMatrix = Array(N + 1) { Array(N + 1) { 0 } }
    val adjMatrix = Array(N + 1) { mutableListOf<Int>() }

    repeat(N-1) {
        val (start, end, distance) = readln().split(" ").map { it.toInt() }

        adjMatrix[start].add(end)
        adjMatrix[end].add(start)

        distanceMatrix[start][end] = distance
        distanceMatrix[end][start] = distance
    }

    repeat(M) {
        val distances = Array(N + 1) { Integer.MAX_VALUE }
        val (start, end) = readln().split(" ").map { it.toInt() }
        distances[start] = 0
        pQueue.add(0 to start)

        while (pQueue.isNotEmpty()) {
            val poll = pQueue.poll()
            val distance = poll.first
            val current = poll.second

            if (distances[current] != distance) continue
            for (next in adjMatrix[current]) {
                if (distances[next] < distances[current] + distanceMatrix[current][next]) continue

                distances[next] = distances[current] + distanceMatrix[current][next]
                pQueue.add(distances[next] to next)
            }
        }

        println(distances[end])
    }
}