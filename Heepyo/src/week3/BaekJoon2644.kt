package week3

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
    val n = readln().toInt()
    val (start, target) = readln().split(" ").map(String::toInt)
    val m = readln().toInt()
    val map = buildMap<Int, MutableList<Int>> {
        for (i in 0 until n) {
            put(i + 1, ArrayList())
        }
        for (j in 0 until m) {
            readln().split(" ").map(String::toInt).also { (a, b) ->
                get(a)?.add(b)
                get(b)?.add(a)
            }
        }
    }

    println(bfs(start, target, map))
}

private fun bfs(start: Int, target: Int, map: Map<Int, List<Int>>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList(listOf(start to 0))
    val visited = HashSet(listOf(start))

    while (!queue.isEmpty()) {
        val (key, value) = queue.poll()

        visited.add(key)
        if (key == target) return value
        for (next in map[key]!!) {
            if (!visited.contains(next)) {
                queue.offer(next to value + 1)
            }
        }
    }
    return -1
}