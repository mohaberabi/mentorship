package com.mohaberabi.fragmentcommunication.usingviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class SharedViewModel : ViewModel() {


    private val _state = MutableStateFlow(SharedState())
    val state = _state.asStateFlow()

    fun onAction(action: SharedActions) {
        when (action) {
            is SharedActions.EmailChanged -> emailChanged(action.email)
            is SharedActions.NameChanged -> nameChanged(action.name)
        }
    }

    private fun nameChanged(value: String) = _state.update { it.copy(name = value) }
    private fun emailChanged(value: String) = _state.update { it.copy(email = value) }
}