package org.example.delegation.exercise.part1

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class ExpensiveResource {


    init {
        doVeryLongTask()
    }

    private fun doVeryLongTask() {
        runBlocking {
            delay(10_000)
            println("Iam Done Of Long Running Task")
        }
    }
}


fun main() {
    println("Just created a lazy instance of expensive resource")
    val expensive: ExpensiveResource by lazy { ExpensiveResource() }
    println("will not consume or do anything till now ")
    expensive.apply { }
    println("i will be executed after expensive is done ")

}