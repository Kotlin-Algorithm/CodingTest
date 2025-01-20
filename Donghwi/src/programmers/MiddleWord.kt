package programmers

fun middleWord() {
    val s1 = "abcde"
    val s = "qwer"

    val arr = s.split("").filter { it.isNotEmpty() }
    var result = ""
    val index = (arr.size / 2).toInt()
    if(arr.size % 2 == 0) {
        result = arr[index - 1] + arr[index + 1]
    } else {
        result = arr[index]
    }

    println(result)
}