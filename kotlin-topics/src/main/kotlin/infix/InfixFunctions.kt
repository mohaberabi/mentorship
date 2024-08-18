package org.example.infix

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


data class Programmer(
    val name: String,
    val languages: List<String> = listOf()
) {

    infix fun likes(language: String) {
        println("Yes Iam $name and i likes $language")
    }

    suspend infix fun learning(language: String) {

        delay(1000L)
        println("Sorry for the delay i was learning $language")
    }
}


infix fun String.concateWith(other: String): String {
    return "${this}${other}"
}

fun main() {
    val mohab = Programmer("Mohab")
    mohab likes "kotlin"
    runBlocking {
        mohab learning "kotlin"
    }
    val mohabS = "Mohab" concateWith "Erabi"
    println(mohabS)
}