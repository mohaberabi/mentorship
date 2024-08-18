package com.mohaberabi.imageloader.domain

import android.graphics.Bitmap

interface ImageDownloader {
    suspend fun loadImage(url: String): Bitmap?
}
