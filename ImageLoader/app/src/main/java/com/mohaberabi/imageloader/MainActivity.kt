package com.mohaberabi.imageloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohaberabi.imageloader.data.CachePersistanceImageStorage
import com.mohaberabi.imageloader.data.DefaultDisptacherPRovider
import com.mohaberabi.imageloader.data.DefaultImageDownloaderFactory
import com.mohaberabi.imageloader.data.DefaultImageLRU
import com.mohaberabi.imageloader.data.DefaultImageLoader
import com.mohaberabi.imageloader.domain.ImageLoader
import com.mohaberabi.imageloader.presentation.compose.DummyCoil
import com.mohaberabi.imageloader.ui.theme.ImageLoaderTheme
import java.io.File

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ImageLoaderTheme {


                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    LazyColumn {
                        items(
                            imgs,
                        ) { url ->
                            DummyCoil(
                                url = url,
                                error = { Text(text = "Error") },
                                loading = { CircularProgressIndicator() })
                        }
                    }


                }
            }
        }
    }


}

val imgs = listOf(
    "https://dunked.com/assets/prod/22884/p17s2tfgc31jte13d51pea1l2oblr3.png",
    "https://dunked.com/assets/prod/22884/p17s2tfgc31jte13d51pea1l2oblr3.png",
    "https://images.freeimages.com/vhq/images/previews/d50/butterfly-papilio-philenor-side-clip-art-545705.jpg?fmt=webp&w=500",
    "https://dunked.com/assets/prod/22884/p17s2tfgc31jte13d51pea1l2oblr3.png",
    "https://images.freeimages.com/vhq/images/previews/d50/butterfly-papilio-philenor-side-clip-art-545705.jpg?fmt=webp&w=500"
)