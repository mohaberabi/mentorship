package org.example.delegation


interface Printer {
    fun print()
}


class SimplePrinter : Printer {
    override fun print() = println("Simple print")
}


class AdvancedPrinter(printer: Printer) : Printer by printer {
    fun advancedPrint() = println("Advanced print")
}


fun main() {
    val simple = SimplePrinter().also {
        it.print()
    }
    val advanced = AdvancedPrinter(simple).also {
        it.advancedPrint()
        it.print()
    }

}