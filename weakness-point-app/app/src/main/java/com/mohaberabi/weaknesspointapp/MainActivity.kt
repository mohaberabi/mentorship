package com.mohaberabi.weaknesspointapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.ui.Modifier
import com.mohaberabi.weaknesspointapp.navigation.AppNavHost
import com.myfitnessbag.order.core.presentation.compose.AppScaffold

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import theme.AppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = rememberWeaknessAppState()
            AppTheme {
                AppScaffold(
                    snackBarHostState = state.hostState,
                ) {
                    AppNavHost(
                        rootNavController = state.navController,
                        onShowSnackBar = {
                            state.scope.launch {
                                state.hostState.showSnackbar(it)
                            }
                        },
                    )
                }
            }
        }
    }
}

