package org.example.scoped


data class Mohab(
    var name: String = "",
    var lastName: String = "",
    var age: Int = 0
)


fun main() {
    val mohab = Mohab().apply {
        name = "mohab"
        lastName = "erabi"
        age = 25
    }
    println(mohab)
}