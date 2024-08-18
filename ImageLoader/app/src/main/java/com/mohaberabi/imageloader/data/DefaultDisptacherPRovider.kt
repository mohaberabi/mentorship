package com.mohaberabi.imageloader.data

import com.mohaberabi.imageloader.domain.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


class DefaultDisptacherPRovider : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}