package com.mohaberabi.imageloader.domain

import android.graphics.Bitmap


interface PersistanceImageStorage {
    fun save(bitmap: Bitmap, path: ImagePath)
    fun get(path: ImagePath): Bitmap?
}