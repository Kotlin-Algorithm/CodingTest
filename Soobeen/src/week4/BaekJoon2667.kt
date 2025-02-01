package week4

import java.util.*

fun main() {
    val n = readln().toInt()
    val matrix = Array(n) { Array(n) { 0 } }
    val visited = Array(n) { Array(n) { false } }
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val result = mutableListOf<Int>()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    repeat(n) { i ->
        val line = readln().split("").filter { it.isNotBlank() }.map { it.toInt() }
        repeat(n) { j ->
            matrix[i][j] = line[j]
        }
    }

    repeat(n) { i ->
        repeat(n) { j ->
            if (matrix[i][j] == 0) return@repeat
            if (visited[i][j]) return@repeat

            visited[i][j] = true
            queue.add(i to j)
            var count = 1
            while (queue.isNotEmpty()) {
                val point = queue.poll()
                val x = point.first
                val y = point.second

                repeat(4) {
                    val nx = x + dx[it]
                    val ny = y + dy[it]

                    if (nx !in 0 until n || ny !in 0 until n) return@repeat
                    if (matrix[nx][ny] == 0 || visited[nx][ny]) return@repeat

                    visited[nx][ny] = true
                    queue.add(nx to ny)
                    count++
                }
            }

            result.add(count)
        }
    }

    println(result.size)
    result.sort()
    result.forEach { println(it) }
}