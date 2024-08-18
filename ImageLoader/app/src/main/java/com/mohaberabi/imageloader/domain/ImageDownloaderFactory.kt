package com.mohaberabi.imageloader.domain


interface ImageDownloaderFactory {
    fun create(path: ImagePath): ImageDownloader
}