package week3

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val tokenizer = StringTokenizer(reader.readLine())
    val matrix = IntArray(n) { tokenizer.nextToken().toInt() }
    val queue: Queue<Int> = LinkedList()
    val visited = Array(n) { false }
    val m = reader.readLine().toInt()
    var count = 1

    visited[m-1] = true
    queue.add(m-1)

    while (queue.isNotEmpty()) {
        val currentIndex = queue.poll()
        if (currentIndex !in 0 until n) continue
        val moveRight = currentIndex + matrix[currentIndex]
        val moveLeft = currentIndex - matrix[currentIndex]

        if (moveRight in 0 until n) {
            if (!visited[moveRight]) {
                count++
                visited[moveRight] = true
                queue.add(moveRight)
            }
        }

        if (moveLeft in 0 until n) {
            if (!visited[moveLeft]) {
                count++
                visited[moveLeft] = true
                queue.add(moveLeft)
            }
        }
    }

    println(count)
}
