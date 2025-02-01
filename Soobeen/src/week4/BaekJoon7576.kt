package week4

import java.util.*

fun main() {
    val (M, N) = readln().split(" ").map { it.toInt() }
    val matrix = Array(N) { readln().split(" ").map { it.toInt() } }
    val distance = Array(N) { Array(M) { -1 } }
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    var isAlreadyRipen = true
    repeat(N) { i ->
        repeat(M) { j ->
            if (matrix[i][j] == 0) {
                isAlreadyRipen = false
            }

            if (matrix[i][j] == 1) {
                distance[i][j] = 0
                queue.add(i to j)
            }

            if (matrix[i][j] == -1) {
                distance[i][j] = -2
            }
        }
    }

    if (isAlreadyRipen) {
        println(0)
        return
    }

    while (queue.isNotEmpty()) {
        val point = queue.poll()
        val x = point.first
        val y = point.second

        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]

            if (nx !in 0 until N || ny !in 0 until M) return@repeat
            if (distance[nx][ny] >= 0 || distance[nx][ny] == -2) return@repeat

            distance[nx][ny] = distance[x][y] + 1
            queue.add(nx to ny)
        }
    }

    var notAllRipen = false
    var max = 0
    repeat(N) { i ->
        repeat(M) { j ->
            if (distance[i][j] > max) max = distance[i][j]
            if (distance[i][j] == -1) notAllRipen = true
        }
    }

    if (notAllRipen) {
        println(-1)
        return
    }

    println(max)
}
