package week7

import java.util.*

class Solution {
    fun solution(numbers: IntArray): List<Int> {
        var result = MutableList(numbers.size) { -1 }
        var stack = Stack<Int>().apply { push(0) }

        for (i in 1..<numbers.size) {
            while (!stack.isEmpty() && numbers[stack.last()] < numbers[i]) {
                result[stack.removeLast()] = numbers[i]
        }
            stack.push(i)
        }
        return result
    }
}