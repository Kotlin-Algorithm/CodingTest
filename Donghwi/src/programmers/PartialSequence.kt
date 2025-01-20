package programmers

class PartialSequence {
    fun partial() {
        val elements = listOf(7, 9, 1, 1, 4)
        val n = elements.size
        val result = mutableSetOf<Int>()

        val circularArray = elements + elements

        for (length in 1.. n) {
            for (start in 0 until n) {
                val sum = circularArray.subList(start, start + length).sum()
                result.add(sum)
            }
        }

        println(result.size)
    }
}