package com.mohaberabi.imageloader.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mohaberabi.imageloader.domain.ImageDownloader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


class HttpUrlImageDownloader : ImageDownloader {
    override suspend fun loadImage(
        url: String,
    ): Bitmap? {
        return try {
            withContext(Dispatchers.IO) {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.inputStream.use { stream ->
                    BitmapFactory.decodeStream(stream)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}


