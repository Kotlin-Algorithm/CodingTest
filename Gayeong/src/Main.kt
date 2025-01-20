import backjoon.B11724
import backjoon.B21736
import hackerrank.RoadsAndLibraries
import programmers.PartialSequence
import programmers.cost
import programmers.middleWord

fun main() {
//    val (n, m) = readln().split(" ").map { it.toInt() }
//    println("$n, $m")
//
//    val tail = MutableList(n) { MutableList(m) { "" } }
//
//    for (i in 0 until n) {
//        tail[i] = readln()
//            .split("")
//            .filter { it.isNotBlank() }
//            .map { it.trim() }
//            .toMutableList()
//    }
//
//    val load = MutableList(n) { MutableList(m) { 0 } }
//    println(load)
//    //만약 - 일경우 오른쪽으로 체크 |일 경우 아래쪽으로 체크
//    //오른쪽 아래쪽으로 갈때는 2중 반복문 필요
//    var count = 0
//    for ( a in 0 until n ) {
//        for( b in 0 until m ) {
//            if(load[a][b] == 1) continue
//            if(tail[a][b] == "-") {
//                var right = b
//                while(right < m && tail[a][right] == "-" && load[a][right] == 0) {
//                    load[a][right] = 1
//                    right++
//                }
//                count++
//            } else if (tail[a][b] == "|") {
//                var height = a
//                while (height < n && tail[height][b] == "|" && load[height][b] == 0) {
//                    load[height][b] = 1
//                    height++
//                }
//                count++
//            }
//
//        }
//    }
//
//    println(load)
//    println(count)
//    val solution = Solution()
//    println(solution.solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))))
//
//    val array = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
//    val result = mutableListOf<String>()
//
//    val ticketMap = array
//        .groupBy(
//            { it[0] },
//            { it[1] }
//        )
//        .mapValues {
//            it.value.sorted().toMutableList()
//        }
//
//    println(ticketMap)
//    fun dfs(current: String) {
//        while(ticketMap[current]?.isNotEmpty() == true) {
//            val next = ticketMap[current]?.removeAt(0) ?: break
//            dfs(next)
//        }
//        result.add(current)
//    }
//    dfs("ICN")
//    println(result.reversed())
//    B21736().needFriend()
//        RoadsAndLibraries().load()
//    B11724().connection()
//    PartialSequence().partial()
    middleWord()
}