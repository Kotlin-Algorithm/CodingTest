package week2

import java.util.*

fun main() {
    val (n, _) = readln().split(" ").map(String::toInt)
    val position = intArrayOf(0, 0)
    val arrays = Array(n) { i ->
        readln().toCharArray().also { chars ->
            chars.takeIf { it.contains('I') }?.indexOfFirst { it == 'I' }?.also {
                position[0] = i
                position[1] = it
            }
        }
    }
    val queue = LinkedList(listOf(position))
    var answer = 0

    while (!queue.isEmpty()) {
        val (x, y) = queue.poll()

        for ((nX, nY) in arrayOf(intArrayOf(x - 1, y), intArrayOf(x, y + 1), intArrayOf(x + 1, y), intArrayOf(x, y - 1))) {
            if (nX > -1 && nY > -1 && nX < arrays.size && nY < arrays[0].size && arrays[nX][nY] != 'X' && arrays[nX][nY] != 'I') {
                if (arrays[nX][nY] == 'P') answer++
                arrays[nX][nY] = 'I'
                queue.offer(intArrayOf(nX, nY))
            }
        }
    }
    println(if (answer == 0) "TT" else answer)
}