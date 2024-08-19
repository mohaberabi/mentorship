package com.mohaberabi.uselessrepos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohaberabi.uselessrepos.presentation.screen.ReposScreen
import com.mohaberabi.uselessrepos.presentation.theme.UselessReposTheme
import com.mohaberabi.uselessrepos.presentation.viewmodel.GithubViewModel
import com.mohaberabi.uselessrepos.presentation.viewmodel.viewmodelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UselessReposTheme {
//                val githubViewModel by
//                viewModels<GithubViewModel>(
//                    factoryProducer = {
//                        viewmodelFactory {
//                            GithubViewModel(getAllReposUseCase = MyApp.githubModule.getAllReposUseCase)
//                        }
//                    }
//                )

                ReposScreen(
                )

            }
        }
    }
}

