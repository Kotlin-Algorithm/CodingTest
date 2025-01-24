package week3

import java.util.*

fun main() {
    val n = readln().toInt()
    val dx = listOf(2, 1, -1, -2, -2, -1, 1, 2)
    val dy = listOf(1, 2, 2, 1, -1, -2, -2, -1)

    repeat(n) outer@ {
        val line = readln().toInt()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val matrix = Array(line) { Array(line) { -1 } }
        val visited = Array(line) { Array(line) { false } }
        val (startX, startY) = readln().split(" ").map { it.toInt() }
        val (endX, endY) = readln().split(" ").map { it.toInt() }

        if (startX == endX && startY == endY) {
            println(0)
            return@outer
        }

        visited[startX][startY] = true
        matrix[startX][startY] = 0
        queue.add(startX to startY)

        while (queue.isNotEmpty()) {
            val point = queue.poll()
            val x = point.first
            val y = point.second

            repeat(8) {
                val nx = x + dx[it]
                val ny = y + dy[it]

                if (nx !in 0 until line || ny !in 0 until line) return@repeat
                if (nx == endX && ny == endY) {
                    println(matrix[x][y] + 1)
                    return@outer
                }
                if (visited[nx][ny] || matrix[nx][ny] != -1) return@repeat

                matrix[nx][ny] = matrix[x][y] + 1
                visited[nx][ny] = true
                queue.add(nx to ny)
            }
        }
    }
}
