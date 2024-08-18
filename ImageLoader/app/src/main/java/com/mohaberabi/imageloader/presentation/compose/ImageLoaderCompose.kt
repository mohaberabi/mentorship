package com.mohaberabi.imageloader.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.mohaberabi.imageloader.MainActivity
import com.mohaberabi.imageloader.data.CachePersistanceImageStorage
import com.mohaberabi.imageloader.data.DefaultDisptacherPRovider
import com.mohaberabi.imageloader.data.DefaultImageDownloaderFactory
import com.mohaberabi.imageloader.data.DefaultImageLRU
import com.mohaberabi.imageloader.data.DefaultImageLoader
import com.mohaberabi.imageloader.data.HttpUrlImageDownloader
import com.mohaberabi.imageloader.domain.ImageDownloader
import com.mohaberabi.imageloader.domain.ImageLoader
import java.io.File


@Composable
fun rememberImageLoader(
): ImageLoader {
    val context = LocalContext.current
    val imageLoader = initializeImageLoader(
        File(context.cacheDir, "imgs")
    )
    return remember {
        imageLoader
    }
}

private fun initializeImageLoader(
    dir: File,
): ImageLoader {
    val lruCache = DefaultImageLRU(100)
    val imageStorage = CachePersistanceImageStorage(dir)
    val downloaderFactory = DefaultImageDownloaderFactory()
    val dispatcher = DefaultDisptacherPRovider()
    val imageLoader = DefaultImageLoader(
        lruCache = lruCache,
        imageStorage = imageStorage,
        downloaderFactory = downloaderFactory,
        dispatchers = dispatcher
    )
    imageLoader.initializeFromDirectory(dir)
    return imageLoader
}
