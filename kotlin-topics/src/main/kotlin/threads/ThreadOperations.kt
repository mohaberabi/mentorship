package org.example.threads


private val thread1 = Thread {

    Thread.sleep(5000)
    println("Thread 1 running")
}
private val thread2 = Thread {
    thread1.join()
    println("Thread 2 running")
}

private val interuptedThread = Thread {
    try {
        while (!Thread.currentThread().isInterrupted) {
            println("Running")
        }
    } catch (e: InterruptedException) {
        println("I WAS INTERUPPTED")
    }
}

fun main() {


    interuptedThread.start()
    interuptedThread.interrupt()
}
