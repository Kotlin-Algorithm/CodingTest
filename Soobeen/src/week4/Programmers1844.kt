package week4

import java.util.*

fun main() {
    val n = maps.size
    val m = maps[0].size
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val distance = Array(n) { Array(m) { -1 } }

    queue.add(0 to 0)
    distance[0][0] = 1

    while (queue.isNotEmpty()) {
        val point = queue.poll()
        val x = point.first
        val y = point.second

        repeat(4) {
            val nx = x + dx[it]
            val ny = y + dy[it]

            if (nx !in 0 until m || ny !in 0 until n) return@repeat
            if (distance[nx][ny] >= 1 || maps[nx][ny] == 0) return@repeat

            if (nx == m-1 && ny == n-1) {
                println(distance[x][y] + 1)
                return
            }

            distance[nx][ny] = distance[x][y] + 1
            queue.add(nx to ny)
        }
    }

    println(-1)
}

val maps = listOf(
    listOf(1, 0, 1, 1, 1),
    listOf(1, 0, 1, 0, 1),
    listOf(1, 0, 1, 1, 1),
    listOf(1, 1, 1, 0, 1),
    listOf(0, 0, 0, 0, 1),
)