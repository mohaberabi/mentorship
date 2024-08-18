package org.example.delegation.exercise.part3


class CachedComputation(
    private val map: MutableMap<Int, Int> = mutableMapOf(),
) : MutableMap<Int, Int> by map {


    fun add(x: Int, y: Int): Int {
        return map.getOrPut(x + y) { x + y }
    }

    fun subtract(x: Int, y: Int): Int {
        return map.getOrPut(x - y) { x - y }
    }

    fun divide(x: Int, y: Int): Int? {
        return if (y == 0) {
            null
        } else {
            return map.getOrPut(x / y) { x / y }
        }

    }

    fun multiply(x: Int, y: Int): Int {
        return map.getOrPut(x * y) { x * y }
    }
}

fun main() {


    val calculator = CachedComputation()
    with(calculator) {
        println(add(1, 2))
        println(add(1, 2))
    }
}