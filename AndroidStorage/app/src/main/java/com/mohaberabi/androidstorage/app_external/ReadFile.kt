package com.mohaberabi.androidstorage.app_external

import android.content.Context
import java.io.File


fun Context.readExternalAppFile(
    env: String? = null,
    name: String,
): ByteArray? {
    val file = File(getExternalFilesDir(env), name)
    return if (file.exists()) {
        file.inputStream().use { it.readBytes() }
    } else {
        null
    }
}

fun Context.readExternalAppText(
    env: String? = null,
    name: String,
): String? {
    val file = File(getExternalFilesDir(env), name)
    return if (file.exists()) {
        file.readText()
    } else {
        null
    }
}