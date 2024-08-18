package org.example.scoped.exercise

class MyCar {
    var brand: String? = null
    var model: String? = null
    var year: Int? = null
}

data class Rectangle(val length: Double, val width: Double)
data class Person(var name: String, var age: Int)


fun solve() {
    val car = MyCar().apply {
        brand = "BMW"
        model = "320i"
        year = 2020
    }.also {
        println("BRAND:${it.brand}, MODEL ${it.model} , YEAR:${it.year}")
    }

}

fun solvePerson() {
    val persons = buildList<Person> {
        repeat(10) {
            add(Person(name = "Person${it}", age = 20 + it))
        }
    }.shuffled().let {
        it.sortedBy { p -> p.age }
    }.also {
        for (p in it) {
            println(p)
        }
    }

}

fun solveRun(ageString: String) {

    val age = ageString.toIntOrNull() ?: run {
        println("can not convert to number")
        -1
    }
}

fun solveRectangle() {

    val rectangle = Rectangle(10.0, 20.0)
    val area = with(rectangle) { length * width }
    val periemeter = with(rectangle) { (2 * length) + (2 * width) }
    println(area)
    println(periemeter)
}

fun main() {
    solveRun("ASDASDSAd")
}