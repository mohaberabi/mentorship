package com.mohaberabi.androidstorage.app_external

import android.content.Context
import java.io.File


fun Context.deleteAppExternalFile(
    env: String? = null,
    name: String,
): Boolean {
    val file = File(getExternalFilesDir(env), name)
    return if (file.exists()) {
        file.delete()
    } else {
        false
    }
}