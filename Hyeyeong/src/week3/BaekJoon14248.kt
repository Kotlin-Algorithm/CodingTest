import java.util.LinkedList
import java.util.Queue
import java.util.Scanner
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val inputArray = IntArray(n) { scanner.nextInt() }
    val start = scanner.nextInt() - 1
    val visited = BooleanArray(n)

    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val currentIndex = queue.poll()
            val currentValue = abs(inputArray[currentIndex])

            val leftIndex = currentIndex - currentValue
            if (leftIndex >= 0 && !visited[leftIndex]) {
                visited[leftIndex] = true
                queue.add(leftIndex)
            }

            val rightIndex = currentIndex + currentValue
            if (rightIndex < n && !visited[rightIndex]) {
                visited[rightIndex] = true
                queue.add(rightIndex)
            }
        }
    }
    bfs(start)
    val answer = visited.count { it }
    println(answer)
}