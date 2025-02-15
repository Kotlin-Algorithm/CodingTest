package week6

import java.io.BufferedReader
import java.io.InputStreamReader

class B1654 {
    fun lan() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (k, n) = br.readLine().split(" ").map(String::toInt)
        val cables = IntArray(k) { br.readLine()!!.toInt() }

        var left = 1
        var right = cables.maxOrNull() ?: 0
        var maxLength = 0

        while(left <= right) {
            val mid = (left + right) / 2
            val count = cables.sumOf { it / mid}

            if(count >= n) {
                maxLength = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        println(maxLength)
    }
}