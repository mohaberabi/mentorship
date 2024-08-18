package org.example.scoped


data class Order(
    val name: String,
    val total: Double
)


fun main() {

    val order: Order? = null


    order?.let {
        println(it.name)
    } ?: run { println("ORDER IS NULL") }
}