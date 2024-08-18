package com.mohaberabi.add_weakness.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohaberabi.add_weakness.screen.AddWeaknessScreenRoot
import kotlinx.serialization.Serializable


@Serializable
data object AddWeaknessRoute

fun NavGraphBuilder.addWeaknessScreen(
    onGoBack: () -> Unit,
    onShowSnackBar: (String) -> Unit,
) = composable<AddWeaknessRoute> {
    AddWeaknessScreenRoot(
        onGoBack = onGoBack,
        onShowSnackBar = onShowSnackBar
    )
}

fun NavController.goToAddWeakness(
) = navigate(AddWeaknessRoute)