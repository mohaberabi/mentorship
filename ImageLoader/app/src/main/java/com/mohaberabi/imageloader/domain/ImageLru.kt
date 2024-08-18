package com.mohaberabi.imageloader.domain

import android.graphics.Bitmap


interface ImageLRU {
    fun set(key: String, value: Bitmap): Bitmap?
    fun get(key: String): Bitmap?
}