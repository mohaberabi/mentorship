package org.example.collections


private val numbers = listOf(5, 2, 3, 1, 4)

private data class HumanBeing(val name: String, val age: Int)

private val people = listOf(
    HumanBeing("mohab", 12),
    HumanBeing("basil", 12),
    HumanBeing("ali", 13),
)

private fun sorted() {
    val sorted = numbers.sorted()
}

private fun sortedBy() {
    val sorted = people.sortedBy { it.age }
}