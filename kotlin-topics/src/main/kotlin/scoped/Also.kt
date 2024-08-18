package org.example.scoped


data class Cart(

    val total: Double,
    val items: List<String>
)


fun main() {
    val cart = Cart(
        total = 0.0,
        items = listOf()
    ).also {
        println(it.items)
    }

}