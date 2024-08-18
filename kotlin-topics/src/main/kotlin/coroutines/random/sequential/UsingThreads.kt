package org.example.coroutines.random.sequential

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


private fun makeOrder(
    item: Product,
): Product {
    println("ORDER ON WAY , the ${item.description} is comming to you")
    Thread.sleep(item.deliveryTime)
    println("ORDER Done , the ${item.description} is arrived to you")
    return item
}

private fun createOrder(
    name: String,
) {
    println("Starting Task -> $name")
    Thread.sleep(1_000)
    println("Finished Task -> $name")
}

private fun seqUsingThreads() {
    val windows = makeOrder(Product.WINDOWS)
    val doors = makeOrder(Product.DOORS)
    createOrder("Starting Working")
    createOrder("Installing ${windows.description}")
    createOrder("Installing ${doors.description}")
}

// will not work launch() is fire and forget
//fun seqUsingCoroutine() {
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

