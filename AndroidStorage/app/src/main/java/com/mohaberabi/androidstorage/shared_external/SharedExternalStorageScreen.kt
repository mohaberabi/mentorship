package com.mohaberabi.androidstorage.shared_external

import android.Manifest
import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mohaberabi.androidstorage.util.readImagesGranted
import com.mohaberabi.androidstorage.util.shouldShowImagesRationale


@Composable
fun SharedExternalStorageScreen(
    modifier: Modifier = Modifier,
) {

    var permisisonGranted by remember {
        mutableStateOf(false)
    }

    var uris by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    var shouldRational by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
        ) { granted ->
            if (granted) {
                permisisonGranted = granted
            } else {
                if ((context as ComponentActivity).shouldShowImagesRationale()) {
                    shouldRational = true
                }
            }

        }

    LaunchedEffect(
        key1 = Unit,
    ) {
        if (!context.readImagesGranted()) {
            launcher.launch(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            permisisonGranted = true
        }
    }

    LaunchedEffect(
        key1 = permisisonGranted,
    ) {

        if (permisisonGranted) {
            uris = queryImagesFromMediaStore(context)
        }
    }

    Scaffold { padding ->
        Column(
            modifier = modifier.padding(padding),
        ) {

            LazyColumn {
                items(uris) { uri ->
                    uri.bitmap(context)?.let {
                        Image(
                            bitmap = it.asImageBitmap(),
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .height(100.dp),
                            contentDescription = "null"
                        )
                    }

                }
            }
        }
    }
}

fun Uri.bitmap(context: Context): Bitmap? {
    return try {
        BitmapFactory.decodeStream(context.contentResolver.openInputStream(this))
    } catch (e: Exception) {
        null
    }
}

fun queryImagesFromMediaStore(context: Context): List<Uri> {
    val imageUris = mutableListOf<Uri>()

    val projection = arrayOf(
        MediaStore.Images.Media._ID,
        MediaStore.Images.Media.DISPLAY_NAME,
        MediaStore.Images.Media.DATE_ADDED
    )

    val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"

    val cursor = context.contentResolver.query(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        projection,
        null,
        null,
        sortOrder
    )

    cursor?.use {
        val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)

        while (it.moveToNext()) {
            val id = it.getLong(idColumn)
            val contentUri =
                ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
            imageUris.add(contentUri)
        }
    }

    return imageUris
}
