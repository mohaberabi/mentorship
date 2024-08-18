package org.example.threads

import java.util.concurrent.locks.ReentrantLock


private val lock = ReentrantLock()


private fun reentrantLockExample() {

    lock.lock()
    try {
        println("Thread safe operation with reentrant ")
    } finally {
        lock.unlock()
    }
}

fun main() {
    reentrantLockExample()
}