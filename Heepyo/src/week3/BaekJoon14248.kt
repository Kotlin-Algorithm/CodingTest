package week3

import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val aList = readln().split(" ").mapNotNull(String::toIntOrNull)
    val s = readln().toInt()
    val queue = LinkedList(listOf(s - 1))
    val visited = mutableSetOf(s - 1)

    while (!queue.isEmpty()) {
        val current = queue.poll()

        for (next in intArrayOf(current - aList[current], current + aList[current])) {
            if (next > -1 && next < n && !visited.contains(next)) {
                visited.add(next)
                queue.offer(next)
            }
        }
    }
    println(visited.size)
}