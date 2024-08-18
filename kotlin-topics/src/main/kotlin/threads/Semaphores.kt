package org.example.threads

import java.util.concurrent.Semaphore


private val semaphore = Semaphore(2)


private var number = 0
private val thread1 = Thread { number++ }
private val thread2 = Thread { number++ }
private val thread3 = Thread { number++ }

private fun accessCriticalSection(onAccess: () -> Unit) {
    semaphore.acquire()
    try {
        onAccess()
    } finally {
        semaphore.release()
    }
}

fun main() {
    println(number)
    accessCriticalSection { thread1.start() }
    accessCriticalSection { thread2.start() }
    accessCriticalSection { thread3.start() }
    println(number) // will always be 2 no other thread after thread1 and 2 can access critical section
}