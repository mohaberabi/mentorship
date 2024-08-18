package com.mohaberabi.weaknesspointapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mohaberabi.add_weakness.navigation.addWeaknessScreen
import com.mohaberabi.add_weakness.navigation.goToAddWeakness
import com.mohaberabi.copy_weakness.presentation.navigation.copyWeaknessScreen
import com.mohaberabi.copy_weakness.presentation.navigation.goToCopyWeakness
import presentation.navigation.WeaknessListingRoute
import presentation.navigation.weaknessListingScreen


@Composable
fun AppNavHost(
    rootNavController: NavHostController,
    startRoute: Any = WeaknessListingRoute,
    onShowSnackBar: (String) -> Unit,
) {
    NavHost(
        navController = rootNavController,
        startDestination = startRoute
    ) {
        weaknessListingScreen(
            onAddWeakness = { rootNavController.goToAddWeakness() },
            onCopyWeakness = { rootNavController.goToCopyWeakness() }
        )
        addWeaknessScreen(
            onGoBack = { rootNavController.popBackStack() },
            onShowSnackBar = onShowSnackBar
        )
        copyWeaknessScreen(
            onGoBack = { rootNavController.popBackStack() },
            onShowSnackBar = onShowSnackBar,
        )
    }
}