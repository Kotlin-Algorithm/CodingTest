package week4

import java.util.*

fun main() {
    val inputs = readln().split(" ").map(String::toInt)
    val (n, m) = inputs
    val arrays = Array(n + 2) { i ->
        if (i in 1..n) {
            (listOf(1) + readln().split(" ").map(String::toInt) + listOf(1)).toMutableList()
        } else {
            MutableList(m + 2) { 1 }
        }
    }.toMutableList()
    val zeroPositions = mutableListOf<Triple<Int, Int, Int>>()
    var answer = 0

    for (i in arrays.indices) {
        for (j in arrays[i].indices) {
            if (arrays[i][j] == 0) {
                zeroPositions.add(Triple(i, j, arrays[i][j]))
            }
        }
    }
    for (i in zeroPositions.indices) {
        for (j in i + 1 until zeroPositions.size) {
            for (k in j + 1 until zeroPositions.size) {
                val (firstI, firstJ, _) = zeroPositions[i]
                val (secondI, secondJ, _) = zeroPositions[j]
                val (thirdI, thirdJ, _) = zeroPositions[k]
                arrays[firstI][firstJ] = 1
                arrays[secondI][secondJ] = 1
                arrays[thirdI][thirdJ] = 1
                answer = maxOf(answer, convertArraysAndGetZeroCount(arrays))
                arrays[firstI][firstJ] = 0
                arrays[secondI][secondJ] = 0
                arrays[thirdI][thirdJ] = 0
            }
        }
    }
    println(answer)
}

fun convertArraysAndGetZeroCount(arrays: MutableList<MutableList<Int>>): Int {
    val arrayCopy = arrays.map { it.toMutableList() }.toMutableList()

    for (i in arrayCopy.indices) {
        for (j in arrayCopy[i].indices) {
            if (arrayCopy[i][j] == 2) {
                bfs(Pair(i, j), arrayCopy)
            }
        }
    }
    return getZeroCount(arrayCopy)
}

fun getZeroCount(arrays: List<List<Int>>): Int {
    return arrays.sumOf { row -> row.count { it == 0 } }
}

fun bfs(start: Pair<Int, Int>, arrays: MutableList<MutableList<Int>>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList(listOf(start))
    arrays[start.first][start.second] = 3

    while (queue.isNotEmpty()) {
        val (i, j) = queue.poll()

        for ((nextI, nextJ) in listOf(i - 1 to j, i to j + 1, i + 1 to j, i to j - 1)) {
            if (arrays[nextI][nextJ] == 0) {
                arrays[nextI][nextJ] = 3

                queue.add(Pair(nextI, nextJ))
            }
        }
    }
}
