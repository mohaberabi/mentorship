package com.mohaberabi.ipcapp.binder

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun BatterServiceScreen(
    isBound: Boolean,
    startMonitoring: () -> Unit,
    stopMonitoring: () -> Unit,
    checkBatteryLevel: () -> Int
) {


    var batteryLevel by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = startMonitoring, enabled = isBound) {
            Text("Start Monitoring")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = stopMonitoring, enabled = isBound) {
            Text("Stop Monitoring")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            batteryLevel = checkBatteryLevel()
        }, enabled = isBound) {
            Text("Check Battery Level")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Current Battery Level: $batteryLevel%")
    }

}