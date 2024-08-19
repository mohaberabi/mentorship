package com.mohaberabi.uselessrepos.data.util

import com.mohaberabi.uselessrepos.domain.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class DefaultDispatcherProvider : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val default: CoroutineDispatcher
        get() = Dispatchers.Main
}