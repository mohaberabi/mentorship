package com.mohaberabi.add_weakness.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mohaberabi.add_weakness.viewmodel.AddWeaknessActions
import com.mohaberabi.add_weakness.viewmodel.AddWeaknessEvents
import com.mohaberabi.add_weakness.viewmodel.AddWeaknessState
import com.mohaberabi.add_weakness.viewmodel.AddWeaknessViewModel
import com.myfitnessbag.order.core.presentation.compose.AppButton
import com.myfitnessbag.order.core.presentation.compose.AppScaffold
import com.myfitnessbag.order.core.presentation.compose.MainAppBar
import com.myfitnessbag.order.core.presentation.compose.PrimaryTextField
import composables.EventCollector
import theme.Spacing


@Composable
fun AddWeaknessScreenRoot(
    modifier: Modifier = Modifier,
    onGoBack: () -> Unit,
    onShowSnackBar: (String) -> Unit,
    viewModel: AddWeaknessViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    EventCollector(viewModel.event) { event ->
        when (event) {
            is AddWeaknessEvents.Error -> onShowSnackBar(event.error.asString(context))
            AddWeaknessEvents.Saved -> onGoBack()
        }
    }
    AddWeaknessScreen(
        state = state,
        onAction = viewModel::onAction,
        onGoBack = onGoBack
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWeaknessScreen(
    modifier: Modifier = Modifier,
    state: AddWeaknessState,
    onAction: (AddWeaknessActions) -> Unit,
    onGoBack: () -> Unit,
) {


    AppScaffold(
        topAppBar = {
            MainAppBar(
                showBackButton = true,
                onBackClick = onGoBack,
            )
        }
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(Spacing.lg),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
        ) {

            PrimaryTextField(
                label = "Name",
                value = state.name,
                onChanged = { onAction(AddWeaknessActions.NameChanged(it)) }
            )

            PrimaryTextField(
                label = "Body",
                value = state.body,
                onChanged = { onAction(AddWeaknessActions.BodyChanged(it)) }
            )

      

            AppButton(
                label = "Save",
                loading = state.loading,
                enabled = state.name.isNotEmpty(),
                onClick = { onAction(AddWeaknessActions.SaveWeakness) }
            )
        }
    }
}