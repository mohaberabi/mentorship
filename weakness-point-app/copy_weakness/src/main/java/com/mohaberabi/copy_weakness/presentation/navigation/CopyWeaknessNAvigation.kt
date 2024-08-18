package com.mohaberabi.copy_weakness.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohaberabi.copy_weakness.presentation.screen.CopyWeaknessScreenRoot
import kotlinx.serialization.Serializable


@Serializable
data object CopyWeaknessRoute


fun NavGraphBuilder.copyWeaknessScreen(
    onGoBack: () -> Unit,
    onShowSnackBar: (String) -> Unit,
) = composable<CopyWeaknessRoute> {
    CopyWeaknessScreenRoot(
        onGoBack = onGoBack,
        onShowSnackBar = onShowSnackBar,
    )
}

fun NavController.goToCopyWeakness() = navigate(CopyWeaknessRoute)