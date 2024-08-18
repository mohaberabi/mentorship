package org.example.collections


private val numbers = listOf(1, 2, 3, 4)


private fun partition() {
    val (even, odd) = numbers.partition { it % 2 == 0 }
// even = [2, 4], odd = [1, 3]

    
}
