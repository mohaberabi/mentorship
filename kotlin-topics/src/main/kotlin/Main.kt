package org.example


private fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}


fun main() {


    val failed = try {
        fail("failed")
    } catch (e: Exception) {
        println(e)
    }
}