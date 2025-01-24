package week3

import java.util.*

fun main() {
    val readln = readlnOrNull()
    val count = readln?.toIntOrNull()

    if (count != null) {
        repeat(count) {
            val input = readlnOrNull()
            val l = input?.toIntOrNull()
            val start = readlnOrNull()?.split(" ")?.mapNotNull { it.toIntOrNull() }
            val end = readlnOrNull()?.split(" ")?.mapNotNull { it.toIntOrNull() }

            if (l != null && start != null && end != null) {
                println(solution(l, start, end))
            }
        }
    }
}

fun solution(l: Int, start: List<Int>, end: List<Int>): Int {
    val array = initArray(start, l)
    val queue: Queue<Pair<List<Int>, Int>> = LinkedList(listOf(start.map { it + 2 } to 0))

    while (queue.isNotEmpty()) {
        val (outed, level) = queue.poll()

        if (outed == end.map { it + 2 }) {
            return level
        }
        for (next in arrayOf(
            arrayOf(outed[0] - 1, outed[1] - 2),
            arrayOf(outed[0] + 1, outed[1] - 2),
            arrayOf(outed[0] + 2, outed[1] - 1),
            arrayOf(outed[0] + 2, outed[1] + 1),
            arrayOf(outed[0] + 1, outed[1] + 2),
            arrayOf(outed[0] - 1, outed[1] + 2),
            arrayOf(outed[0] - 2, outed[1] + 1),
            arrayOf(outed[0] - 2, outed[1] - 1)
        )) {
            if (array[next[0]][next[1]] == 1) {
                array[next[0]][next[1]] = 3
                queue.add(Pair(listOf(next[0], next[1]), level + 1))
            }
        }
    }

    return 0
}

fun initArray(start: List<Int>, l: Int): Array<Array<Int>> {
    val result = Array(l + 4) { i ->
        if (i in 2 until l + 2) {
            Array(l + 4) { j ->
                if (j in 2 until l + 2) 1 else 0
            }
        } else {
            Array(l + 4) { 0 }
        }
    }
    result[start[0] + 2][start[1] + 2] = 3
    return result
}