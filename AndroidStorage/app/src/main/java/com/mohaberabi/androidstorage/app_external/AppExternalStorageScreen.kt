package com.mohaberabi.androidstorage.app_external

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun AppExternalStorageScreen(
    modifier: Modifier = Modifier,
) {


    var data by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    Scaffold { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = data,
            )

            Button(
                onClick = {
                    data =
                        context.readExternalAppFile(
                            name = "example.txt",
                        )?.toString(Charsets.UTF_8)
                            ?: ""
                },
            ) {
                Text(text = "Read File")
            }
            Button(
                onClick = {
                    context.saveExternalAppFile(
                        data = "Mohab The Best Loser".toByteArray(),
                    )
                },
            ) {
                Text(text = "Write  File")
            }
        }
    }

}