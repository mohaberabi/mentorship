package org.example.threads

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


private val coroutineMutex = Mutex()
private var count = 0
private suspend fun accessCriticalSection() {
    coroutineMutex.withLock {
        count++
        println("iam a coroutine and i entered the critical")
    }
}


fun main() {

//    runBlocking {
//
//        val dummy = async {
//            accessCriticalSection()
//            delay(1000)
//        }
//        dummy.await()
//        println(count)
//        launch { accessCriticalSection() }
//        println(count)
//        launch { accessCriticalSection() }
//        println(count)
//
//    }
//    println(count)

    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        accessCriticalSection()
    }
    scope.launch {
        accessCriticalSection()
    }
    scope.launch {
        accessCriticalSection()
    }
    println(count)
    scope.launch {
        accessCriticalSection()
    }
    println(count)

    
}