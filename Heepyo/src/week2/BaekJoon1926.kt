package week2

import java.util.LinkedList
import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val array = Array(n + 2) { if ((1..n).contains(it)) "0 ${readln()} 0".split(" ").map(String::toInt).toIntArray() else IntArray(m + 2) }
    var count = 0
    var maxAreaSize = 0

    for (i in 1..n) {
        for (j in 1..m) {
            if (array[i][j] == 1) {
                count += 1
                maxAreaSize = max(maxAreaSize, bfs(i to j, array))
            }
        }
    }
    println(count)
    println(maxAreaSize)
}

private fun bfs(start: Pair<Int, Int>, array: Array<IntArray>): Int {
    val queue = LinkedList(listOf(start))
    var count = 0

    while (!queue.isEmpty()) {
        val (i, j) = queue.removeFirst()
        array[i][j] = 2
        count++

        for ((nextI, nextJ) in arrayOf(i - 1 to j, i to j + 1, i + 1 to j, i to j - 1)) {
            if (array[nextI][nextJ] == 1) {
                array[nextI][nextJ] = 2

                queue.offer(nextI to nextJ)
            }
        }
    }
    return count
}