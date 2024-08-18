package org.example.threads

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference


private data class AtomicData(var name: String)

private val atomicInt = AtomicInteger(100)
private val atomicData = AtomicReference(AtomicData("Mohab"))

private fun doOnAtomicInt() {
    println(atomicInt.incrementAndGet())
}


private fun doOnAtomicObject() {
    atomicData.get().also {
        it.name = "Basil"
        println(it.name)
    }
}

fun main() {
    doOnAtomicInt()
    doOnAtomicObject()
}