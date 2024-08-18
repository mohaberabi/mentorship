package com.mohaberabi.androidstorage.app_external

import android.content.Context
import java.io.File


fun Context.saveExternalAppFile(
    env: String? = null,
    name: String = "example.txt",
    data: ByteArray,
) {

    val external = getExternalFilesDir(env)
    val file = File(external, name)
    file.outputStream()
        .use { output ->
            output.write(data)
        }

}

fun Context.saveExternalAppText(
    env: String? = null,
    name: String = "example.txt",
    data: String,
) {
    val external = getExternalFilesDir(env)
    val file = File(external, name)
    file.writeText(data)
}

