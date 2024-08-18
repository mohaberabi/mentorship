package com.mohaberabi.deepvsdynamiclinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohaberabi.deepvsdynamiclinks.ui.theme.DeepVsDynamicLinksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            DeepVsDynamicLinksTheme {

                intent?.data?.let { uri ->
                    val path = uri.path
                    path?.let { p ->
                        if (p.startsWith("/admin")) {
                            val username = uri.getQueryParameter("username") ?: ""
                            val id = uri.getQueryParameter("id")?.toIntOrNull() ?: 0
                            DeepScreen(
                                label = username,
                                id = id
                            )
                        } else {
                            val label = when {
                                p.startsWith("/deep") -> "Deep"
                                p.startsWith("/product") -> "Products"
                                p.startsWith("/profile") -> "Profile"
                                else -> ""
                            }
                            DeepScreen(
                                label = label,
                            )
                        }

                    }

                } ?: Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {

                    Text(text = "HomeScreen")
                }

            }
        }
    }
}

@Composable
fun DeepScreen(
    modifier: Modifier = Modifier,
    label: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = label,
        )
    }
}

@Composable
fun DeepScreen(
    modifier: Modifier = Modifier,
    label: String,
    id: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = label,
        )
        Text(text = id.toString())
    }
}


