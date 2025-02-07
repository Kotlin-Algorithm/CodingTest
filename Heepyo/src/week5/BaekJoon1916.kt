package week5

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph: Map<Int, MutableList<IntArray>> = buildMap<Int, MutableList<IntArray>>() {
        for (i in 0 until m) {
            val (u, v, w) = readln().split(" ").map(String::toInt)

            computeIfAbsent(u) { integer: Int? -> mutableListOf<IntArray>() }.add(intArrayOf(v, w))
        }
    }
    val (start, end) = readln().split(" ").map(String::toInt)
    val queue = PriorityQueue<IntArray>(compareBy { o -> o[1] }).apply { offer(intArrayOf(start, 0)) }
    val map: MutableMap<Int, Int> = buildMap { put(start, 0) }.toMutableMap()

    while (!queue.isEmpty()) {
        val outed = queue.poll()

        if (outed[1] > map.getOrDefault(outed[0], Int.Companion.MAX_VALUE)) continue
        map.put(outed[0], outed[1])
        for (next in graph.getOrDefault(outed[0], mutableListOf<IntArray?>())) {
            if (map.containsKey(next!![0])) continue
            queue.offer(intArrayOf(next[0], outed[1] + next[1]))
        }
    }
    println(map.getOrDefault(end, 0))
}