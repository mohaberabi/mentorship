package org.example.threads


private val lock = Any()


private fun syncedExample() {
    synchronized(lock) {
        println("Thread Safe ")
    }
}


@Volatile
private var volatile: Int = 0


private val thread1 = Thread {
    volatile = 100
}
private var thread2 = Thread {
    println(volatile)
}
private var thread3 = Thread {
    println(volatile)
}

fun main() {
    thread2.start()
    thread1.start()
    thread3.start()
}