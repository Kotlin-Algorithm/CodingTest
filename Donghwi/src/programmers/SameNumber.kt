package programmers

class SameNumber {
    fun solution() {
        val arr = arrayOf(4,4,4,3,3)
        val result = arr.filterIndexed {
            index, value -> index == 0 || value != arr[index - 1]
        }.toIntArray()
    }
}