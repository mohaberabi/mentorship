package org.example.coroutines.random.sequential

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


enum class Product(
    val description: String,
    val deliveryTime: Long
) {
    DOORS(
        "doors",
        750,
    ),
    WINDOWS(
        "windows",
        1_250,
    )
}

private suspend fun makeOrder(
    item: Product,
): Product {
    println("ORDER ON WAY , the ${item.description} is comming to you")
    delay(item.deliveryTime)
    println("ORDER Done , the ${item.description} is arrived to you")
    return item
}

private suspend fun createOrder(
    name: String,
) {
    println("Starting Task -> $name")
    delay(1_000)
    println("Finished Task -> $name")
}

private suspend fun seqUsingThreads(
) {
    val windows = makeOrder(Product.WINDOWS)
    val doors = makeOrder(Product.DOORS)
    createOrder("Starting Working")
    createOrder("Installing ${windows.description}")
    createOrder("Installing ${doors.description}")
}

// will not work launch() is fire and forget
//private fun seqUsingCoroutine() {
//    runBlocking {
//        val windows = launch { makeOrder(Product.WINDOWS) }
//        val doors = launch { makeOrder(Product.DOORS) }
//        launch {
//            createOrder("Starting Working")
//            createOrder("Installing ${windows.description}")
//            createOrder("Installing ${doors.description}")
//        }
//    }
//}
// this will not block the thread , the thread still can do another work
private fun seqUsingCoroutineCorrect(
) {
    runBlocking {
        val windows = async { makeOrder(Product.WINDOWS) }
        val doors = async { makeOrder(Product.DOORS) }
        launch {
            createOrder("Starting Working")
            createOrder("Installing ${windows.await().description}")
            createOrder("Installing ${doors.await().description}")
        }
    }
}

fun main() {
    seqUsingCoroutineCorrect()

}