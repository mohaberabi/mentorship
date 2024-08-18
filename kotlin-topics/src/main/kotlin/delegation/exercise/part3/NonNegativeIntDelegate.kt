package org.example.delegation.exercise.part3

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NonNegativeIntDelegate(
    private val initial: Int = 0,
) : ReadWriteProperty<Any?, Int> {
    private var value: Int = initial

    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>,
    ): Int = value

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: Int,
    ) {
        if (value < 0) {
            this.value = 0
        } else {
            this.value = value
        }
    }
}

fun main() {
    var num by NonNegativeIntDelegate()
    println(num)
    num = 1
    println(num)
    num = -100
    println(num)
}