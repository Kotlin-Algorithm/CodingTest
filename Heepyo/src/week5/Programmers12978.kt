package week5

import java.util.*

// TC 1, 2, 3 이 통과 되지 않음
class Solution {
    fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
        val graph = buildMap<Int, MutableList<Pair<Int, Int>>> {
            for ((a, b, c) in road) {
                computeIfAbsent(a) { mutableListOf<Pair<Int, Int>>() }.add(b to c)
                computeIfAbsent(b) { mutableListOf<Pair<Int, Int>>() }.add(a to c)
            }
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy(Pair<Int, Int>::second)).apply { offer(1 to 0) }
        val visited = mutableSetOf<Int>()

        while (!pq.isEmpty()) {
            val (current, totalValue) = pq.poll()

            if (totalValue > k) {
                return visited.size
            }
            visited.add(current)
            for ((next, nextValue) in graph[current] ?: emptyList()) {
                if (visited.contains(next)) continue
                pq.offer(next to totalValue + nextValue)
            }
        }
        return 0
    }
}