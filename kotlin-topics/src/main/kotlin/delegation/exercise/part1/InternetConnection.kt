package org.example.delegation.exercise.part1

import kotlin.properties.Delegates
import kotlin.random.Random


class InternetConnection(
    private val initial: Int,
) {


    companion object {
        private const val MIN_SPEED = 1
        private const val MAX_SPEED = 100
    }

    var internetSpeed: Int by Delegates.vetoable(
        initialValue = initial,
    ) { prop, old, new ->
        new in MIN_SPEED..MAX_SPEED

    }

    fun startConnection() {
        repeat(100) {
            val randomSpeed = Random.nextInt(0, 200)
            internetSpeed = randomSpeed
            println("Attempted to set speed to $randomSpeed, actual speed is $internetSpeed")
        }
    }

    init {
        startConnection()
    }

}

fun main() {
    InternetConnection(50)
}