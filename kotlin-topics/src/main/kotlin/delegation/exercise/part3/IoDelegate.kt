package org.example.delegation.exercise.part3

import java.io.File
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class IoDelegate(
    private val fileName: String,
    private val default: String = ""
) : ReadWriteProperty<Any?, String> {
    private val file = File(fileName)
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return if (file.exists()) {
            file.readText()
        } else {
            default
        }
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        file.writeText(value)
    }

}

fun main() {
    val file by IoDelegate("mohab.txt")
}