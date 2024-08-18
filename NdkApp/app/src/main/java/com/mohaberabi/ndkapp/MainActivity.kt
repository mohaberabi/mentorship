package com.mohaberabi.ndkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohaberabi.nativeapp.NativeLib

import com.mohaberabi.ndkapp.ui.theme.NdkAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NdkAppTheme {

                App()

            }
        }
    }


}

@Composable
fun App(
    modifier: Modifier = Modifier,
) {

    val native by remember {
        mutableStateOf(NativeLib())
    }
    val value by remember {
        mutableStateOf(native.stringFromJNI())
    }
    Scaffold { padding ->
        Column(
            modifier = modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = value,
            )

        }
    }
}

