package week3

import java.util.*

fun jump() {
    val n = readln().toInt()
    val distance = readln().split(" ").map { it.toInt() }
    val start = readln().toInt() - 1

    val visited = BooleanArray(n)
    val queue: Queue<Int> = LinkedList()

    queue.add(start)
    visited[start] = true

    var count = 0

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        count++

        val left = current - distance[current]
        val right = current + distance[current]

        if (left in 0 until n && !visited[left]) {
            visited[left] = true
            queue.add(left)
        }
        if (right in 0 until n && !visited[right]) {
            visited[right] = true
            queue.add(right)
        }
    }
    println(count)
}