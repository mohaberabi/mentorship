package com.mohaberabi.androidstorage.internal

import android.content.Context
import java.io.File


inline fun Context.deleteInternalFile(
    path: String,
    onError: (Throwable) -> Unit
) {
    try {
        deleteFile(path)
    } catch (e: Exception) {
        onError(e)
    }

}

inline fun Context.deleteInternalFile(
    root: File = filesDir,
    path: String,
    onError: (Throwable) -> Unit
) {
    val file = File(root, path)
    try {
        file.delete()
    } catch (e: Exception) {
        onError(e)
    }

}