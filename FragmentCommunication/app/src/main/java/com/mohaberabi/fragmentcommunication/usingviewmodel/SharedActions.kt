package com.mohaberabi.fragmentcommunication.usingviewmodel


sealed interface SharedActions {


    data class NameChanged(val name: String) : SharedActions
    data class EmailChanged(val email: String) : SharedActions


}