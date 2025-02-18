import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val S = scanner.nextInt()
    val arr = Array(N) { scanner.nextInt() }

    var answer = Int.MAX_VALUE
    var sum = 0
    var end = 0

    for (start in 0 until N) {
        sum += arr[start]

        while (sum >= S) {
            answer = minOf(answer, start - end + 1)
            sum -= arr[end]
            end++
        }
    }
    println(if (answer == Int.MAX_VALUE) 0 else answer)
}