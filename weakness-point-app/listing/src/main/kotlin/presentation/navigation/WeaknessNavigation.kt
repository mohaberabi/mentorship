package presentation.navigation

import WeaknessListingScreenRoot
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object WeaknessListingRoute

fun NavGraphBuilder.weaknessListingScreen(
    onAddWeakness: () -> Unit,
    onCopyWeakness: () -> Unit,
) = composable<WeaknessListingRoute> {
    WeaknessListingScreenRoot(
        onAddWeakness = onAddWeakness,
        onCopyWeakness = onCopyWeakness
    )
}