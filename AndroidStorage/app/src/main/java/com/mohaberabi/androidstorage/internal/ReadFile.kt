package com.mohaberabi.androidstorage.internal

import android.content.Context
import java.io.File


inline fun Context.readInternalFile(
    root: File = filesDir,
    path: String = "file.txt",
    onDone: (ByteArray) -> Unit,
    onError: (Throwable) -> Unit,
) {
    try {
        val file = File(root, path)
        file.inputStream()
            .use { input ->
                onDone(input.readBytes())
            }
    } catch (e: Exception) {
        onError(e)
    }

}

inline fun Context.readInternalFile(
    onError: (Throwable) -> Unit,
    onDone: (ByteArray) -> Unit,
    name: String = "file.txt",
) {
    try {
        openFileInput(name)
            .use { input ->
                onDone(input.readBytes())
            }
    } catch (e: Exception) {
        onError(e)
    }

}