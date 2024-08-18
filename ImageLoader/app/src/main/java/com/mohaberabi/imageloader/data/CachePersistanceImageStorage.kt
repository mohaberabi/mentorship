package com.mohaberabi.imageloader.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mohaberabi.imageloader.domain.ImagePath
import com.mohaberabi.imageloader.domain.PersistanceImageStorage
import java.io.File


class CachePersistanceImageStorage(
    private val root: File
) : PersistanceImageStorage {


    init {
        if (!root.exists()) {
            root.mkdirs()
        }
    }

    override fun save(
        bitmap: Bitmap,
        path: ImagePath
    ) {
        val file = File(
            root,
            path.cacheKey,
        )
        file.outputStream()
            .use { output ->
                bitmap.compress(
                    Bitmap.CompressFormat.PNG,
                    100, output
                )
            }
    }

    override fun get(
        path: ImagePath,
    ): Bitmap? {
        val file = File(root, path.cacheKey)
        return if (!file.exists()) {
            null
        } else {
            file.inputStream().use {
                BitmapFactory.decodeStream(it)
            }
        }
    }


}
