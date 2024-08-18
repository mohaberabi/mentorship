package org.example.scoped


data class Car(
    val made: String,
    val year: Int,
    val model: String
)


fun main() {
    val car: Car? = null
    car?.let {
        printCar(it)
    }
}

fun printCar(car: Car) {

    println("Made: ${car.made}")
    println("Year: ${car.year}")
    println("Model:${car.model}")
}