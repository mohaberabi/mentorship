package org.example.scoped.compare


data class ProgrammingLang(
    var name: String?,
    var nullSafe: Boolean = false,
    var isOop: Boolean? = null,
    var isFunctional: Boolean? = null,
    var staticTyped: Boolean? = null,
    var checkedExceptions: Boolean? = null,
)

fun beforeApply() {
    val kotlin = ProgrammingLang(
        name = "Kotlin",
        staticTyped = true,
        isOop = true,
        isFunctional = true,
        nullSafe = true,
        checkedExceptions = false
    )
}

fun afterApply() {
    val kotlin = ProgrammingLang("Kotlin")
        .apply {
            staticTyped = true
            isOop = true
            isFunctional = true
            nullSafe = true
            checkedExceptions = false
        }
}