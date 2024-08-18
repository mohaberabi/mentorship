package org.example.threads

import java.util.concurrent.CountDownLatch


private val latch = CountDownLatch(3)
private fun task() {
    println("Task is executed")
    latch.countDown()
}


fun main() {
    repeat(3) {
        Thread { task() }.start()
    }
    latch.await()
    println("All Tasks completed")
}