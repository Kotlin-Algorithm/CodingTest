package week4

import java.util.*

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val matrix = Array(N) { Array(M) { 0 } }
    val points = mutableListOf<Pair<Int, Int>>()
    val walls = mutableListOf<List<Pair<Int, Int>>>()
    val results = mutableListOf<Int>()
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    repeat(N) { i ->
        val line = readln().split(" ").map { it.toInt() }
        repeat(M) { j ->
            matrix[i][j] = line[j]
            if (matrix[i][j] == 0) points.add(i to j)
        }
    }

    for (i in 0 until points.size) {
        for (j in i + 1 until points.size) {
            for (k in j + 1 until points.size) {
                walls.add(listOf(points[i], points[j], points[k]))
            }
        }
    }

    repeat(walls.size) {
        val wallList = walls[it]
        val firstWall = wallList[0]
        val secondWall = wallList[1]
        val thirdWall = wallList[2]

        matrix[firstWall.first][firstWall.second] = 1
        matrix[secondWall.first][secondWall.second] = 1
        matrix[thirdWall.first][thirdWall.second] = 1

        var vCount = 0
        val visited = Array(N) { Array(M) { false } }
        repeat(N) { i ->
            repeat(M) { j ->
                if (matrix[i][j] != 2 || visited[i][j]) return@repeat

                visited[i][j] = true
                queue.add(i to j)
                vCount++

                while(queue.isNotEmpty()) {
                    val poll = queue.poll()
                    val x = poll.first
                    val y = poll.second

                    repeat(4) {
                        val nx = x + dx[it]
                        val ny = y + dy[it]

                        if (nx !in 0 until N || ny !in 0 until M) return@repeat
                        if (matrix[nx][ny] != 0 || visited[nx][ny]) return@repeat

                        visited[nx][ny] = true
                        queue.add(nx to ny)
                        vCount++
                    }
                }
            }
        }

        var wCount = 0
        repeat(N) { i ->
            repeat(M) { j ->
                if (matrix[i][j] == 1) wCount++
            }
        }

        results.add(N * M - (vCount + wCount))
        matrix[firstWall.first][firstWall.second] = 0
        matrix[secondWall.first][secondWall.second] = 0
        matrix[thirdWall.first][thirdWall.second] = 0
    }

    println(results.max())
}