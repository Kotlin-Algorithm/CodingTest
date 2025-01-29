package week4

import java.util.*

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val matrix = Array(N + 1) { Array(N + 1) { 0 } }
    val adj = Array(N + 1) { mutableListOf<Int>() }
    val stack = Stack<Int>()

    repeat(N-1) {
        val line = readln().split(" ").map { it.toInt() }
        val start = line[0]
        val end = line[1]
        val distance = line[2]

        adj[start].add(end)
        adj[end].add(start)

        matrix[start][end] = distance
        matrix[end][start] = distance
    }

    repeat(M) {
        val visited = mutableListOf<Int>()
        var distance = 0
        var prev = 0
        val (start, end) = readln().split(" ").map { it.toInt() }

        visited.add(start)
        stack.push(start)

        while(stack.isNotEmpty()) {
            val current = stack.pop()
            val nextList = adj[current]
            visited.add(current)

            for (next in nextList) {
                if (next in visited) continue
                stack.push(next)
            }
            prev = current
        }
    }
}
