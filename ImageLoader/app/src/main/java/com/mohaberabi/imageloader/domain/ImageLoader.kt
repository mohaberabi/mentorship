package com.mohaberabi.imageloader.domain

import android.graphics.Bitmap


interface ImageLoader {
    suspend fun load(path: String): Bitmap?
}



