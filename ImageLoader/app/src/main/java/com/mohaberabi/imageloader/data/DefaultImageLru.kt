package com.mohaberabi.imageloader.data

import android.graphics.Bitmap
import androidx.collection.LruCache
import com.mohaberabi.imageloader.domain.ImageLRU

class DefaultImageLRU(
    private val initialSize: Int = 100,
) : ImageLRU {
    private val lru = LruCache<String, Bitmap>(initialSize)
    override fun set(
        key: String,
        value: Bitmap,
    ) = lru.put(key, value)

    override fun get(key: String): Bitmap? = lru[key]

}