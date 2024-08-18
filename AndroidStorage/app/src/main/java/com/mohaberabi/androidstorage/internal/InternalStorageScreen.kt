package com.mohaberabi.androidstorage.internal

import android.content.Context
import android.widget.Toast
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
fun InternalStorageScreen(modifier: Modifier = Modifier) {


    val context = LocalContext.current


    var readFile by remember {
        mutableStateOf("")
    }
    Scaffold { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = readFile,
            )
            Button(
                onClick = {
                    context.saveInternalFile(
                        name = "file.txt",
                        onError = { e -> },
                        onDone = {
                            Toast.makeText(
                                context,
                                "Saved",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                    )
                },
            ) {
                Text(
                    text = "Press to save file ",
                )
            }
            Button(
                onClick = {
                    context.readInternalFile(
                        onDone = { readFile = it.toString(Charsets.UTF_8) },
                        onError = { e ->
                            Toast.makeText(
                                context,
                                "File not found or something went wrong",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                    )
                },
            ) {
                Text(
                    text = "Press to read file ",
                )
            }
        }
    }
}

