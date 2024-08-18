package com.mohaberabi.weaknesspointapp

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope


data class WeaknessAppState(


    val navController: NavHostController,
    val scope: CoroutineScope,
    val hostState: SnackbarHostState,
)


@Composable
fun rememberWeaknessAppState(

): WeaknessAppState {
    val controller = rememberNavController()
    val scope = rememberCoroutineScope()
    val hostState = SnackbarHostState()
    return remember {
        WeaknessAppState(
            navController = controller,
            scope = scope,
            hostState = hostState,
        )
    }
}