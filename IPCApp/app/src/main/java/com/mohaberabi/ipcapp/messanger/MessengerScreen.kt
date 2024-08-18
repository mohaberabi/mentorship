package com.mohaberabi.ipcapp.messanger

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MessengerServiceScreen(
    statusText: String,
    isBound: Boolean,
    sendCommand: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Status: $statusText")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { sendCommand(MessangerService.MSG_START_TASK) }, enabled = isBound) {
            Text("Start Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { sendCommand(MessangerService.MSG_STOP_TASK) }, enabled = isBound) {
            Text("Stop Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { sendCommand(MessangerService.MSG_CHECK_STATUS) }, enabled = isBound) {
            Text("Check Status")
        }
    }
}