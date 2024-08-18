package org.example.collections


private val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8)
private val simmiler = listOf(1, 1, 1, 4, 4, 4, 7, 7)


private val objects = listOf("String", null)
private fun filter() {
    val even = numbers.filter { it % 2 == 0 }
    //[2,4,6,8]
}

private fun filterNot() {

    val noEven = numbers.filterNot { it % 2 == 0 }

    //[1,3,5,7]
}

private fun filterNotNull() {

    val notNull = objects.filterNotNull()
    //[[String]]
}

private fun distnict() {
    val distncit = simmiler.distinct()
    //[1,4,7]
}