package com.mohaberabi.copy_weakness.presentation.screen

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.copy_weakness.presentation.viewmodel.CopyWeaknessActions
import com.mohaberabi.copy_weakness.presentation.viewmodel.CopyWeaknessEvents
import com.mohaberabi.copy_weakness.presentation.viewmodel.CopyWeaknessState
import com.mohaberabi.copy_weakness.presentation.viewmodel.CopyWeaknessViewModel
import com.mohaberabi.copy_weakness.presentation.viewmodel.WeaknessStatus
import com.myfitnessbag.order.core.presentation.compose.AppLoader
import com.myfitnessbag.order.core.presentation.compose.AppScaffold
import com.myfitnessbag.order.core.presentation.compose.MainAppBar
import composables.EventCollector


@Composable
fun CopyWeaknessScreenRoot(
    viewmodel: CopyWeaknessViewModel = hiltViewModel(),
    onGoBack: () -> Unit,
    onShowSnackBar: (String) -> Unit,
) {

    val context = LocalContext.current

    EventCollector(
        flow = viewmodel.event,
    ) { event ->
        when (event) {
            CopyWeaknessEvents.Copied -> onGoBack()
            is CopyWeaknessEvents.Error -> onShowSnackBar(event.error.asString(context))
        }
    }
    val state by viewmodel.state.collectAsStateWithLifecycle()
    CopyWeaknessScreen(
        state = state,
        onGoBack = onGoBack,
        onAction = viewmodel::onAction
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CopyWeaknessScreen(
    modifier: Modifier = Modifier,
    state: CopyWeaknessState,
    onGoBack: () -> Unit,
    onAction: (CopyWeaknessActions) -> Unit,

    ) {


    AppScaffold(
        modifier = modifier,
        topAppBar = {
            MainAppBar(
                showBackButton = true,
                onBackClick = onGoBack,
            )
        },
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            when (state.state) {

                WeaknessStatus.Error -> Text(text = "Something went wrong ")
                WeaknessStatus.Populated -> {

                    LazyColumn {
                        item {
                            Text(
                                text = "Copy weakness points",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        items(
                            state.weaknesses,
                        ) { weak ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                            ) {
                                Text(
                                    text = weak.title,
                                    modifier = Modifier.clickable {
                                        onAction(
                                            CopyWeaknessActions.OnWeaknessClick(
                                                weak
                                            )
                                        )
                                    }
                                )
                            }
                        }
                    }
                }

                else -> AppLoader()
            }
        }
    }

}