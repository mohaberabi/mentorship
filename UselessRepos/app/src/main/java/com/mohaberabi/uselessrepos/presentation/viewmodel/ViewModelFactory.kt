package com.mohaberabi.uselessrepos.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


fun <VM : ViewModel> viewmodelFactory(initializer: () -> VM): ViewModelProvider.Factory {

    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}