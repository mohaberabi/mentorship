package com.mohaberabi.imageloader.data

import android.graphics.Bitmap
import android.util.Log
import com.mohaberabi.imageloader.domain.DispatcherProvider
import com.mohaberabi.imageloader.domain.ImageDownloaderFactory
import com.mohaberabi.imageloader.domain.ImageLRU
import com.mohaberabi.imageloader.domain.ImageLoader
import com.mohaberabi.imageloader.domain.ImagePath
import com.mohaberabi.imageloader.domain.PersistanceImageStorage
import kotlinx.coroutines.withContext
import java.io.File


class DefaultImageLoader(
    private val lruCache: ImageLRU,
    private val imageStorage: PersistanceImageStorage,
    private val downloaderFactory: ImageDownloaderFactory,
    private val dispatchers: DispatcherProvider
) : ImageLoader {

    override suspend fun load(
        path: String,
    ): Bitmap? {

        return try {
            withContext(dispatchers.io) {
                val imgPath = ImagePath(path)
                lruCache.get(imgPath.cacheKey)?.let {
                    Log.d("lru", "Loaded from lru ")
                    return@withContext it
                }
                imageStorage.get(imgPath)?.let {
                    Log.d("storage", "Loaded from storage ")
                    lruCache.set(imgPath.cacheKey, it)
                    return@withContext lruCache.get(imgPath.cacheKey)
                }
                val downloader = downloaderFactory.create(imgPath)
                downloader.loadImage(imgPath.path)?.let { downlaoded ->
                    Log.d("remote", "Loaded from remote ")
                    lruCache.set(imgPath.cacheKey, downlaoded)
                    imageStorage.save(downlaoded, imgPath)
                    return@withContext downlaoded
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }


    }

    fun initializeFromDirectory(directory: File) {
        val files = directory.listFiles() ?: return
        for (file in files) {
            Log.d("path", file.absolutePath)
            if (file.isFile) {
                val imagePath = ImagePath(file.absolutePath)
                val bitmap = imageStorage.get(imagePath)
                bitmap?.let {
                    lruCache.set(imagePath.cacheKey, it)
                }
            }
        }
    }
}