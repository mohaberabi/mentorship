package com.mohaberabi.androidstorage.internal

import android.content.Context
import java.io.File

inline fun Context.saveInternalFile(
    name: String = "file.txt",
    data: ByteArray = "mohab the loser".toByteArray(),
    onDone: () -> Unit,
    onError: (Throwable) -> Unit
) {
    try {
        openFileOutput(
            name, Context.MODE_PRIVATE,
        ).use { output ->
            output.write(data)
            onDone()
        }
    } catch (e: Exception) {
        onError(e)
    }
}

inline fun Context.saveInternalFile(
    root: File = filesDir,
    path: String = "file.txt",
    data: ByteArray = "mohab the loser".toByteArray(),
    onDone: () -> Unit,
    onError: (Throwable) -> Unit

) {
    try {
        val file = File(root, path)

        file.outputStream(
        ).use { output ->
            output.write(data)
            onDone()
        }
    } catch (e: Exception) {
        onError(e)
    }
}
