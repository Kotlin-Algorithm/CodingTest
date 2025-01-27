package week4

import java.util.*

class B2667 {
    fun groupNumberDFS() {
        val n = readln().toInt()
        val map = Array(n) { readln().toCharArray().map { it - '0' }.toIntArray() }
        val visited = Array(n) { BooleanArray(n) }
        val dx = arrayOf(-1, 1, 0, 0)
        val dy = arrayOf(0, 0, -1, 1)
        val result = mutableListOf<Int>()

        fun dfs(x: Int, y: Int): Int {
            visited[x][y] = true
            var count = 1
            for( i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx in 0 until n &&
                    ny in 0 until n &&
                    map[nx][ny] == 1 &&
                    !visited[nx][ny]
                ) {
                    count += dfs(nx, ny)
                }
            }
            return count
        }

        for(i in 0 until n) {
            for( j in 0 until n) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    result.add(dfs(i, j))
                }
            }
        }

        println(result.size)
        result.sorted().forEach { println(it) }
    }

    fun groupNumberBFS() {
        val n = readln().toInt()
        val map = Array(n) { readln().toCharArray().map { it - '0' }.toIntArray() }
        val visited = Array(n) { BooleanArray(n) }
        val dx = arrayOf(-1, 1, 0, 0)
        val dy = arrayOf(0, 0, -1, 1)
        val result = mutableListOf<Int>()

        fun bfs(x: Int, y: Int): Int {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(x, y))
            visited[x][y] = true
            var count = 1

            while(queue.isNotEmpty()) {
                val (cx, cy) = queue.poll()

                for(i in 0..<4) {
                    val nx = cx + dx[i]
                    val ny = cy + dy[i]
                    if(
                        nx in 0..<n &&
                        ny in 0..<n &&
                        map[nx][ny] == 1 &&
                        !visited[nx][ny]
                    ) {
                        queue.add(Pair(nx, ny))
                        visited[nx][ny] = true
                        count++
                    }
                }
            }
            return count
        }

        for(i in 0 until n) {
            for(j in 0 until n) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    result.add(bfs(i, j))
                }
            }
        }

        println(result.size)
        result.sorted().forEach { println(it) }
    }
}