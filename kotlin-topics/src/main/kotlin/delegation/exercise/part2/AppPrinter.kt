package org.example.delegation.exercise.part2

interface AppPrinter {
    fun print()
}

interface AppScanner {
    fun scan()
}

class BasicPrinter : AppPrinter {
    override fun print() {
        println("Basic Printer")
    }
}

class BasicScanner : AppScanner {
    override fun scan() {
        println("Basic Scanner")
    }
}

class MultiFunctionDevice(
    private val printer: AppPrinter, private val scanner: AppScanner,
) : AppPrinter by printer,
    AppScanner by scanner {
    fun doMultiFunction() {
        println("I Lied to You I Do Not Do Anything i only do ")
        print()
        scan()
    }
}

fun main() {

    val printer = BasicPrinter()
    val scanner = BasicScanner()
    val multi = MultiFunctionDevice(
        printer,
        scanner
    ).also {
        it.doMultiFunction()
    }
}