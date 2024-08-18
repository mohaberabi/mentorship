package org.example.scoped.compare


data class User(val name: String, val password: String)


fun beforeAlso() {
    val user = User("mohab", "12345678")


    logIn(user)
}


fun afterAlso() {
    val user = User(
        "mohab",
        "12345678"
    ).also {
        logIn(it)
    }
}

fun logIn(user: User) {
    println("User Logged in with ${user.name} and password*******")
}