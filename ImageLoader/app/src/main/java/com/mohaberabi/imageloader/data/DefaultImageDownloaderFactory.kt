package com.mohaberabi.imageloader.data

import com.mohaberabi.imageloader.domain.ImageDownloader
import com.mohaberabi.imageloader.domain.ImageDownloaderFactory
import com.mohaberabi.imageloader.domain.ImagePath


class DefaultImageDownloaderFactory : ImageDownloaderFactory {
    override fun create(path: ImagePath): ImageDownloader {
        return HttpUrlImageDownloader()

    }
}