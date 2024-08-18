import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.feature.listing.R
import com.myfitnessbag.order.core.presentation.compose.AppButton
import com.myfitnessbag.order.core.presentation.compose.AppLoader
import composables.AppFab
import presentation.viewmodel.WeaknessListingState
import presentation.viewmodel.WeaknessListingViewModel
import theme.AppTheme
import theme.Spacing


@Composable
fun WeaknessListingScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: WeaknessListingViewModel = hiltViewModel(),
    onAddWeakness: () -> Unit,
    onCopyWeakness: () -> Unit,
) {


    val state by viewModel.state.collectAsStateWithLifecycle()
    WeaknessListingScreen(
        modifier = modifier,
        state = state,
        onAddWeakness = onAddWeakness,
        onCopyWeakness = onCopyWeakness,
    )
}


@Composable
fun WeaknessListingScreen(
    modifier: Modifier = Modifier,
    state: WeaknessListingState,
    onAddWeakness: () -> Unit,
    onCopyWeakness: () -> Unit,
) {


    Scaffold(
        floatingActionButton = {
            Column(
                Modifier.wrapContentHeight(),
            ) {

                if (state is WeaknessListingState.Done && state.weaknessList.isNotEmpty()) {
                    AppFab(
                        icon = Icons.Default.Add,
                        onClick = onAddWeakness,
                    )

                }

                Spacer(
                    modifier = Modifier.height(Spacing.lg),
                )
                AppFab(
                    icon = Icons.Default.Search, onClick = onCopyWeakness,
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
        ) {
            when (state) {
                is WeaknessListingState.Done -> {
                    if (state.weaknessList.isEmpty()) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = "Looks like you don't have weakness points yet")
                            AppButton(
                                onClick = { onAddWeakness() },
                                label = "Add now "
                            )
                        }
                    } else {
                        LazyColumn {
                            items(state.weaknessList) { weak ->
                                Text(
                                    text = weak.title,
                                    modifier=Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }

                WeaknessListingState.Error -> {
                    Text(
                        text = stringResource(R.string.something_went_wrong)
                    )
                }

                WeaknessListingState.Loading -> AppLoader()
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
private fun PreviewScreenListing() {

    AppTheme {

        WeaknessListingScreen(
            state = WeaknessListingState.Done(emptyList()),
            onAddWeakness = {},
        ) {

        }
    }
}