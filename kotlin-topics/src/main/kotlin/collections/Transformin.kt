package org.example.collections

private val numbers = listOf(1, 2, 3)
private val alpha = listOf("one", "two", "three")

private data class Human(val name: String, val age: Int)

private fun map() {
    val doubled = numbers.map { it * 2 }
    println(doubled)
}


private fun flatMap() {
    val expanded = numbers.flatMap { listOf(it, it * 2) }
    //[1,2,2,4,3,6]
}

private fun zip() {
    val zipped = numbers.zip(alpha)
    //[("1,one),(2,two),(3,three)]
}

private fun associatedBy() {

    val people = listOf(
        Human("mohab", 12),
        Human("basil", 12),
        Human("ali", 13),
    )
    val associatedBy = people.associateBy { it.name }
    // ("mohab"->("mohab",12))...etc
}

private fun groupedBy() {

    val groupByLength = alpha.groupBy { it.length }
    // [3->["one,two"], 4-> [four]]
}

private fun chunk() {
    val chunkced = (1..10).toList().chunked(3)
    // [[1,2,3],[4,5,6],[7,8,9],[10]]
}