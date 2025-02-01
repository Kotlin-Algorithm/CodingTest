package week5

import java.util.*

fun main() {
    val n = readln().toInt()

    repeat(n) {
        val (computerCount, d, c) = readln().split(" ").map { it.toInt() }
        val adj = Array(computerCount + 1) { mutableListOf<IntArray>() }  // start, end, cost
        val pQueue: Queue<IntArray> = PriorityQueue(compareBy { it[1] })
        val distance = IntArray(computerCount + 1) { Int.MAX_VALUE } // Array -> IntArray

        repeat(d) {
            val (start, end, cost) = readln().split(" ").map { it.toInt() }
            adj[end].add(intArrayOf(start, cost))
        }

        pQueue.add(intArrayOf(c, 0))
        distance[c] = 0

        while (pQueue.isNotEmpty()) {
            val (current, cost) = pQueue.poll()
            if (distance[current] != cost) continue

            for ((next, nextCost) in adj[current]) {
                if (distance[next] <= distance[current] + nextCost) continue

                distance[next] = distance[current] + nextCost
                pQueue.add(intArrayOf(next, distance[next]))
            }
        }

        val count = distance.count { it != Int.MAX_VALUE }
        val maxTime = distance.map { if (it == Int.MAX_VALUE) 0 else it }.maxOf { it }

        println("$count $maxTime")
    }
}

// IntArray vs Array 차이점 + 메모리 얼마나 많이 차이나는지
// BufferedReader() 공부
// Pair 객체의 메모리 사용량
// 코틀린에서 filter 내부 구현
// BufferedWriter()