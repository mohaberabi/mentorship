package com.mohaberabi.androidstorage.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat

fun Context.isPermissionGranted(
    permission: String,
): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission,
    ) == PackageManager.PERMISSION_GRANTED
}


fun Context.readImagesGranted(
): Boolean = isPermissionGranted(
    Manifest.permission.READ_MEDIA_IMAGES
)

fun ActivityResultLauncher<String>.requestReadImages(
) = launch(Manifest.permission.READ_MEDIA_IMAGES)


fun Activity.shouldShowRational(permission: String) =
    shouldShowRequestPermissionRationale(permission)

fun Activity.shouldShowImagesRationale() =
    shouldShowRational(Manifest.permission.READ_MEDIA_IMAGES)