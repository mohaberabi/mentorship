package org.example.threads


private var counter = 0

@Synchronized
fun increment() {
    counter++
}

private val thread1 = Thread { repeat(100) { increment() } }
private val thread2 = Thread { repeat(100) { increment() } }


fun main() {


    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()

    println("Counter: $counter")
}
