package org.example.coroutines.random

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


private val mohab = "mohab"
private val basil = "basil"

fun play() {
    println("$mohab Box")
    println("$basil PoerSlam")
    println("$mohab Box")
    println("$basil Suplex")
    println("$mohab Box")
    println("$basil Pinning 1,2,3! Win")
}

fun playOrganize() {
    println("$basil PoerSlam")
    println("$basil Suplex")
    /// oops how to pin in wrestling match  in the middle it must be last thing to happen
    println("$basil Pinning 1,2,3! Win")
    println("$mohab Box")
    println("$mohab Box")
    println("$mohab Box")
}

fun playWithCoroutine() {

    runBlocking {
        println("$basil PoerSlam")
        println("$basil Suplex")
        println("$basil Pinning 1,2,3! Win")
        //

        println("$mohab Box")
        println("$mohab Box")
        println("$mohab Box")
    }
}

fun playWithCoroutineLaunched() {

    runBlocking {
        launch {
            println("$basil PoerSlam")
            yield()
            println("$basil Suplex")
            yield()
            println("$basil Pinning 1,2,3! Win")

        }
        launch {
            println("$mohab Box")
            yield()
            println("$mohab Box")
            yield()

        }
    }
}

fun main() {
    playWithCoroutineLaunched()

}