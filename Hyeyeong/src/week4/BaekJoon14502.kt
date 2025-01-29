import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

//1. 바이러스 인근에 벽 3개를 세운다
//2. 그리고 안전 영역의 크기가 가장 큰 최댓값을 구하라

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val M = scanner.nextInt()
    val arr = Array(N) { IntArray(M) { scanner.nextInt() } }
    var answer = 0

    val directions = arrayOf(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, -1),
        Pair(0, 1),
    )

    fun bfs(i: Int, j: Int, spreadVirusArr: Array<IntArray>) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(i, j))

        while (queue.isNotEmpty()) {
            val (ci, cj) = queue.poll() //지금 나와야하는 queue. 빠져나가고 없어진다.
            for ((di, dj) in directions) {
                val ni = ci + di
                val nj = cj + dj
                if (ni in 0..<N && nj in 0..<M && spreadVirusArr[ni][nj] == 0) {
                    queue.add(Pair(ni, nj)) //queue에 nowi, nowj를 넣어준다.
                    spreadVirusArr[ni][nj] = 2 // 주변으로 2가 퍼져나간다.
                }
            }
        }
    }

    fun addSafeZoneCount(spreadVirusArr: Array<IntArray>): Int {
        var zoneCount = 0
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (spreadVirusArr[i][j] == 0) {
                    zoneCount++
                }
            }
        }
        return zoneCount
    }

    fun setWalls(count: Int) {
        if (count == 3) {
            //벽은 3개까지만 세운다.
            val spreadVirusArr = Array(N) { arr[it].copyOf() }
            for (i in arr.indices) {
                for (j in arr[i].indices) {
                    if (spreadVirusArr[i][j] == 2) {
                        bfs(i, j, spreadVirusArr)
                    }
                }
            }
            answer = maxOf(answer, addSafeZoneCount(spreadVirusArr))
            return
        }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1 // 주변이 벽이라면 1을 세운다.
                    setWalls(count + 1)
                    arr[i][j] = 0
                }
            }
        }
    }

    setWalls(0)
    println(answer)
}