package org.example.delegation.exercise.part1

import kotlin.properties.Delegates


class BankAccount(
    private val balance: Double,
) {

    companion object {
        private const val TXN_FEE = 2.0
    }

    var accountBalance by Delegates.observable(
        balance,
    ) { property, old, new ->

        val fees = if (new > old) {
            "and a Transaction fees of amount $TXN_FEE was deducted "
        } else {
            ""
        }
        println("Your Balance Was ${old} ${fees} your new balance is now ${new}")
    }

    fun addBalance(value: Double) {
        accountBalance += (value - TXN_FEE)
    }
}

fun main() {
    val account = BankAccount(100.0)
    account.addBalance(500.0)
    account.addBalance(500.0)
    account.addBalance(500.0)
    account.addBalance(500.0)


}