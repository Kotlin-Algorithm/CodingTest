package week4

import java.util.*
import kotlin.math.max

private val startList: MutableList<IntArray> = ArrayList()

fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    val array = Array(n + 2) { i ->
        if (i in (1..n))
            "-1 ${readln()} -1"
                .split(" ")
                .map(String::toInt)
                .also {
                    if (it.contains(1)) it.indices.forEach { j ->
                        if (it[j] == 1) startList.add(intArrayOf(i, j))
                    }
                }
                .toIntArray()
        else
            IntArray(m + 2) { -1 }
    }
    var answer = 0

    bfs(array)
    for (i in 1 until array.size - 1) {
        Arrays.sort(array[i])
        answer = if (array[i].binarySearch(0) > -1) {
            println(-1)
            return
        } else {
            max(answer, array[i][array[i].size - 1])
        }
    }
    println(answer - 1)
}

private fun bfs(array: Array<IntArray>) {
    val queue: Queue<IntArray> = LinkedList(startList)

    while (!queue.isEmpty()) {
        val outed = queue.poll()

        for (next in arrayOf(
            intArrayOf(outed[0] - 1, outed[1]),
            intArrayOf(outed[0], outed[1] + 1),
            intArrayOf(outed[0] + 1, outed[1]),
            intArrayOf(outed[0], outed[1] - 1)
        )) {
            if (array[next[0]][next[1]] == 0) {
                array[next[0]][next[1]] = array[outed[0]][outed[1]] + 1

                queue.offer(intArrayOf(next[0], next[1]))
            }
        }
    }
}