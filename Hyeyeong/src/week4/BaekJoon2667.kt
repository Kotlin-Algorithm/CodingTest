import java.util.LinkedList
import java.util.Queue

//1. 배열을 순회하기
//2. 미방문 집이라면? bfs 호출
//3. 상하좌우, size 내에서, 방문 여부 확인

fun main() {
    val size = readln().toInt()
    val mapArr = Array(size) { readln().map { it.toString().toInt() } }
    val visited = Array(size) { IntArray(size) { 0 } }
    val ansList = mutableListOf<Int>() //단지수를 담고있는 배열

    fun bfs(i: Int, j: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(i, j)) //데이터 삽입
        visited[i][j] = 1 //1로 방문 표시
        var count = 1

        val directions = arrayOf(
            Pair(-1, 0), // 위
            Pair(1, 0),  // 아래
            Pair(0, -1), // 왼쪽
            Pair(0, 1)   // 오른쪽
        )

        while (queue.isNotEmpty()) {
            val (ci, cj) = queue.poll()
            for ((di, dj) in directions) {
                val ni = ci + di
                val nj = cj + dj

                if (ni in 0 until size && nj in 0 until size && visited[ni][nj] == 0 && mapArr[ni][nj] == 1) {
                    queue.add(Pair(ni, nj))
                    visited[ni][nj] = 1
                    count++
                }
            }
        }
        return count
    }

    for (i in mapArr.indices) {
        for (j in mapArr.indices) {
            if (mapArr[i][j] == 1 && visited[i][j] == 0) {
                ansList.add(bfs(i, j))
            }
        }
    }
    ansList.sort()
    println(ansList.size)
    ansList.forEach { println(it) }
}