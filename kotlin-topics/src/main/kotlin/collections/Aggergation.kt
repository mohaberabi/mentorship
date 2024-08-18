package org.example.collections


private val numbers = listOf(1, 2, 3, 4)


private fun average() {
    val sum = numbers.sum()

}


private fun maxOrNull() {
    val max = numbers.maxOrNull()
    //4
}

private fun reduce() {
    val reduced = numbers.reduce { acc, num -> acc * num }
    //23
}

private fun fold() {
    val folded = numbers.fold(0) { initial, result -> initial + result }
    //10
}