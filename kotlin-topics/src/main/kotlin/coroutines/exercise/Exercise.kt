package org.example.coroutines.exercise

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun testFlow() = listOf<Int>(
    1, 2, 123, 123, 12123, 22, 2, 22, 12, 2, 3, 1012, 21213,
).asFlow()

fun testStringFlow() = listOf(
    "1", "2", "C", "3", "E", "4", "5",
).asFlow()


suspend fun getData(): Int {
    println("Executing")
    delay(1000)
    return Random.nextInt()
}


suspend fun getAllData() {

    val time = measureTimeMillis {
        withContext(Dispatchers.IO) {
            val first = async { getData() }
            val second = async { getData() }
            val result = first.await() + second.await()
            println(result)
        }
    }
    println(time)

}

fun testStringFlow2(): Flow<String> = flow {
    emit("1")
    emit("2")
    emit("three")
    emit("4")
    emit("5")

}

fun handleStringFlow() {

    runBlocking {
        testStringFlow2()
            .map { it.toInt() }
            .catch {
                println("Could Not Convert")
                emit(-1)
            }
            .collect { println(it) }
    }
}

fun mapFlow() {
    runBlocking {
        testFlow().filter { it % 2 != 0 }.map {
            it * it
        }.collect { value ->

            println(value)
        }
    }

}


fun testStateFlow(): Unit = runBlocking {
    val downloadProgress = MutableStateFlow(0)

    launch {
        for (i in 1..100) {
            delay(50L)
            downloadProgress.value = i
        }
    }

    downloadProgress.collect { progress ->
        println("Download progress: $progress%")
        if (progress == 100) {
            println("Download complete!")
            return@collect
        }

    }


}

fun testSharedFlowW() {
    runBlocking {
        val timeFlow = MutableStateFlow<Long>(0L)

        launch {
            while (true) {
                delay(1000L)
                timeFlow.emit(System.currentTimeMillis())
            }
        }

        launch {
            timeFlow.collect { timestamp ->
                println("Collector 1: Current time is $timestamp")
            }
        }

        launch {
            delay(3000L)  // Start collecting after 3 seconds
            timeFlow.collect { timestamp ->
                println("Collector 2: Current time is $timestamp")
            }
        }

    }
}

fun testSharedFlow() {
    runBlocking {
        val timeFlow = MutableSharedFlow<Long>()

        launch {
            while (true) {
                delay(1000L)
                timeFlow.emit(System.currentTimeMillis())
            }
        }

        launch {
            timeFlow.collect { timestamp ->
                println("Collector 1: Current time is $timestamp")
            }
        }

        launch {
            delay(3000L)  // Start collecting after 3 seconds
            timeFlow.collect { timestamp ->
                println("Collector 2: Current time is $timestamp")
            }
        }

    }
}


fun main() {

    testSharedFlowW()
}