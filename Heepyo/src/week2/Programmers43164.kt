package week2

import java.util.*

class Solution {
    fun solution(tickets: Array<Array<String>>): List<String> {
        val pairStack = PairStack<Int, String>(START)
        val answer = Stack<String>()
        fun backtracking() {
            for (i in tickets.indices) {
                if (pairStack.indexContains(i) || pairStack.isNotValidPath(tickets, i)) continue
                pairStack.push(i, tickets[i][1])
                if (pairStack.size() < tickets.size) backtracking()
                else if (answer.isEmpty()) answer.addAll(pairStack.pathStack)
                pairStack.pop()
            }
        }

        tickets.sortBy { it[1] }
        backtracking()
        return answer
    }

    companion object {
        private const val START = "ICN"
    }
}

class PairStack<T, S>(start: S) {
    private val mIndexStack = Stack<T>()
    val pathStack = Stack<S>()

    init {
        pathStack.push(start)
    }

    fun push(idx: T, path: S) {
        mIndexStack.push(idx)
        pathStack.push(path)
    }

    fun pop() {
        mIndexStack.pop()
        pathStack.pop()
    }

    fun size(): Int {
        return mIndexStack.size
    }

    fun indexContains(index: T): Boolean {
        return mIndexStack.contains(index)
    }

    fun isNotValidPath(tickets: Array<Array<String>>, i: Int): Boolean {
        return pathStack.peek() != tickets[i][0]
    }
}
