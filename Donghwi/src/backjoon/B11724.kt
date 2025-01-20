package backjoon

class B11724 {
    fun connection() {
        val (n, m) = readln().split(" ").map(String::toInt)
        val node = Array(m) { Array(n) { 0 } }
        println(node.contentToString())
    }
}