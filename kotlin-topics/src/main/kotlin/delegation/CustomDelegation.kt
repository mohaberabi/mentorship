package org.example.delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class CustomDelegate : ReadWriteProperty<Any?, String> {
    private var default = "Default"
    override fun getValue(
        thisRef: Any?,
        property: KProperty<*>,
    ): String = default

    override fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String
    ) {
        default = value
    }

}

fun main() {
    var custom: String by CustomDelegate()

    println(custom)
    custom = "mohab"
    println(custom)
}