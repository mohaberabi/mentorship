package org.example.delegation.exercise.part1


data class Engineer constructor(
    val map: Map<String, Any?>,
) {
    val name: String by map
    val age: Int by map
    val special: String by map

}

fun main() {


    val map = mapOf(
        "name" to "mohab",
        "age" to 25,
        "special" to "Computer Engineering"
    )
    val mohab = Engineer(map).also {
        println(it)
    }
}