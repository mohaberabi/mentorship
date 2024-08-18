package org.example.delegation.exercise.part2

class SafeList<T>(
    private val innerList: MutableList<T> = mutableListOf(),
) : MutableList<T> by innerList {
    override fun add(element: T): Boolean {
        return if (innerList.toSet().contains(element)) {
            false
        } else {
            innerList.add(element)
        }
    }

    override fun add(
        index: Int,
        element: T,
    ) {
        if (innerList.toSet().contains(element)) {
            return
        } else {
            innerList.add(index, element)
        }
    }

    override fun addAll(
        index: Int,
        elements: Collection<T>,
    ): Boolean {
        return elements.fold(false) { modified, element ->
            if (!innerList.toSet().contains(element)) {
                innerList.add(index + innerList.indexOf(element), element)
                true
            } else {
                modified
            }
        }
    }

    override fun addAll(
        elements: Collection<T>,
    ): Boolean {
        val notExist = elements.filter { !innerList.toSet().contains(it) }
        return innerList.addAll(notExist)
    }
}

fun main() {
    val list = SafeList<Int>()
    list.add(1)
    list.add(1)

    for (x in list) {
        println(x)
    }
    println()
    list.add(2)
    list.add(1, 2)
    for (x in list) {
        println(x)
    }
}