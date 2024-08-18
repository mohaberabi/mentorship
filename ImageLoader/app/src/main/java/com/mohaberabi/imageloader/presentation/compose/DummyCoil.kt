package com.mohaberabi.imageloader.presentation.compose

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale


enum class ImageStatus {
    Loading,
    Error,
    Populated
}

@Composable
fun DummyCoil(
    modifier: Modifier = Modifier,
    url: String,
    description: String? = null,
    error: @Composable (Modifier) -> Unit,
    loading: @Composable (Modifier) -> Unit,
    contentScale: ContentScale = ContentScale.Crop,
) {

    val loader = rememberImageLoader()
    var status by remember {
        mutableStateOf(ImageStatus.Loading)
    }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(
        key1 = Unit,
    ) {
        val cached = loader.load(url)
        if (cached != null) {
            status = ImageStatus.Populated
            bitmap = cached
        } else {
            status = ImageStatus.Error
        }
    }

    when (status) {
        ImageStatus.Loading -> loading(modifier)
        ImageStatus.Error -> error(modifier)
        ImageStatus.Populated -> {
            val image = bitmap!!.asImageBitmap()
            Image(
                bitmap = image,
                modifier = modifier,
                contentDescription = description,
                contentScale = contentScale
            )
        }
    }

}

//package com.mohaberabi.imageloader.presentation.compose
//
//import android.graphics.Bitmap
//import androidx.compose.foundation.Image
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//
//
//enum class ImageStatus {
//    Loading,
//    Error,
//    Populated
//}
//
//@Composable
//fun DummyCoil(
//    modifier: Modifier = Modifier,
//    url: String,
//    description: String? = null,
//    error: @Composable (Modifier) -> Unit,
//    loading: @Composable (Modifier) -> Unit,
//    contentScale: ContentScale = ContentScale.Crop,
//) {
//
//    val loader = rememberImageLoader()
//    var status by remember {
//        mutableStateOf(ImageStatus.Loading)
//    }
//    LaunchedEffect(
//        key1 = Unit,
//    ) {
//        val cached = lru.get(url)
//        if (cached != null) {
//            status = ImageStatus.Populated
//            bitmap = cached
//        } else {
//            loader.loadImage(url)?.let {
//                bitmap = lru.set(url, it)
//                status = ImageStatus.Populated
//            } ?: run {
//                status = ImageStatus.Error
//            }
//
//        }
//    }
//
//    when (status) {
//        ImageStatus.Loading -> loading(modifier)
//        ImageStatus.Error -> error(modifier)
//        ImageStatus.Populated -> {
//            val image = bitmap!!.asImageBitmap()
//            Image(
//                bitmap = image,
//                modifier = modifier,
//                contentDescription = description,
//                contentScale = contentScale
//            )
//        }
//    }
//
//}