package com.mohaberabi.uselessrepos.domain.util

import kotlinx.coroutines.CoroutineDispatcher


interface DispatcherProvider {


    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
    val default: CoroutineDispatcher
}