package com.mohaberabi.imageloader.domain

data class ImagePath(
    val path: String,
) {

    val isUrl: Boolean
        get() = path.startsWith("http://") || path.startsWith("https://")

    val cacheKey: String
        get() = if (isUrl) path.hashCode().toString() else path


}
