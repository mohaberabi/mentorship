package org.example.delegation

import kotlin.properties.Delegates


val lazyValue: String by lazy {
    println("Compueted")
    "Hello"
}
var observable: String by Delegates.observable(
    "initial",
) { property, prev, new ->
    println("Property ${property.name} Changed From $prev to $new")

}
var vetoableProperty: Int by Delegates.vetoable(
    0,
) { property, oldValue, newValue ->
    newValue >= 0
}

class User(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val hello = lazyValue
    val map = mapOf("name" to "mohab", "age" to 25)
    val user = User(map)
    println(user.age)
    println(user.name)
}