import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        val adj = Array(N + 1) { mutableListOf<IntArray>() }
        val pQueue: Queue<IntArray> = PriorityQueue(compareBy { it[1] }) // current, cost
        val distances = IntArray(N + 1) { Int.MAX_VALUE }

        repeat(road.size) {
            val (start, end, cost) = road[it]
            adj[start].add(intArrayOf(end, cost))
            adj[end].add(intArrayOf(start, cost))
        }

        pQueue.add(intArrayOf(1, 0))
        distances[1] = 0

        while (pQueue.isNotEmpty()) {
            val poll = pQueue.poll()
            val current = poll[0]
            val cost = poll[1]

            if (distances[current] != cost) continue

            for ((next, nextCost) in adj[current]) {
                if (distances[next] < distances[current] + nextCost) continue

                distances[next] = distances[current] + nextCost
                pQueue.add(intArrayOf(next, distances[next]))
            }
        }

        answer = distances.count { it <= k }

        return answer
    }
}
