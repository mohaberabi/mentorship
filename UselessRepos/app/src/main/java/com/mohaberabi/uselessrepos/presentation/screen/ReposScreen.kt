package com.mohaberabi.uselessrepos.presentation.screen

import android.view.View
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mohaberabi.uselessrepos.MainActivity
import com.mohaberabi.uselessrepos.MyApp
import com.mohaberabi.uselessrepos.presentation.viewmodel.GithubState
import com.mohaberabi.uselessrepos.presentation.viewmodel.GithubStatus
import com.mohaberabi.uselessrepos.presentation.viewmodel.GithubViewModel
import com.mohaberabi.uselessrepos.presentation.viewmodel.viewmodelFactory


@Composable
fun ReposScreen(
    modifier: Modifier = Modifier,
    viewModel: GithubViewModel = uselessViewModel {
        GithubViewModel(
            getAllReposUseCase = MyApp.githubModule.getAllReposUseCase,
        )
    },
) {

    val state by viewModel.state.collectAsState(initial = GithubState())

    Scaffold {

            padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),

            ) {

            when (state.state) {

                GithubStatus.Error -> Text(text = "Something Went Wrong")
                GithubStatus.Populated -> {
                    LazyColumn {
                        items(state.repos) { repo ->
                            Column(
                                modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.Start,
                            ) {

                                Text(
                                    text = repo.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = repo.fullName,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                repo.description?.let {
                                    Text(
                                        text = it,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        maxLines = 5,
                                        overflow = TextOverflow.Ellipsis,
                                    )
                                }
                                HorizontalDivider()
                            }
                        }
                    }
                }

                else -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
inline fun <reified VM : ViewModel> uselessViewModel(
    crossinline init: () -> VM
): VM {
    val context = LocalContext.current
    val activity = context as MainActivity
    val vm = activity.viewModels<VM>(
        factoryProducer = {
            viewmodelFactory { init() }
        }
    )
    return vm.value
}