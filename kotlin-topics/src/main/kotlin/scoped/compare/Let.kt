package org.example.scoped.compare


fun beforeLet(
    name: String?,
) {
    if (name != null) {
        println(name)
    }
}

fun afterLet(
    name: String?,
) {
    name?.let { println(it) }
}

