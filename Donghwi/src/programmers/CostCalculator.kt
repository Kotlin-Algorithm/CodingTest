package programmers

fun cost() {
    val price = 3
    val money = 20
    val count = 4
    val result = 0

    var sum = 0L
    for(i in 1..count) {
        sum += i * price
    }
    val answer = money - sum
    if(answer < 0) -answer else 0

}