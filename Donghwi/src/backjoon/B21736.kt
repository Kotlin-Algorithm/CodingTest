package backjoon

class B21736 {
    fun needFriend() {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val array = mutableListOf<MutableList<String>>()

        for(i in 0 until n) {
            val temp = readln().split("").filter { it.isNotEmpty() }
            array.add(temp.toMutableList())
        }

        val visited = Array(n + 2) { Array(m + 2) { 0 } }
        val directionX = listOf(-1, 1, 0, 0)
        val directionY = listOf(0, 0, -1, 1)

        var tempX = 0
        var tempY = 0

        for(i in 0 until n) {
            for(j in 0 until m) {
                if(array[i][j] == "I") {
                    tempX = i
                    tempY = j
                    break
                }
            }
        }

        val startX = tempX + 1
        val startY = tempY + 1

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(startX, startY))
        visited[startX][startY] = 1

        var friendCount = 0

        while(queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            for(d in 0 until 4) {
                val nearX = x + directionX[d]
                val nearY = y + directionY[d]

                if(
                    nearX in 1 until n &&
                    nearY in 1 until m &&
                    visited[nearX][nearY] == 0 &&
                    array[nearX - 1][nearY - 1] != "X"
                ) {
                    visited[nearX][nearY] = 1
                    queue.add(Pair(nearX, nearY))

                    if(array[nearX - 1][nearY - 1] == "P") {
                        friendCount++
                    }
                }
            }
        }

        if(friendCount > 0) {
            println(friendCount)
        } else {
            println("TT")
        }
    }
}
