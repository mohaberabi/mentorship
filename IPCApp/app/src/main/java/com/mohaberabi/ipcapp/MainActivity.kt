package com.mohaberabi.ipcapp

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohaberabi.ipcapp.binder.BatterServiceScreen
import com.mohaberabi.ipcapp.binder.BatteryMonitorService
import com.mohaberabi.ipcapp.messanger.MessengerActivity
import com.mohaberabi.ipcapp.ui.theme.IPCAppTheme


class MainActivity : ComponentActivity() {
//    private lateinit var batteryService: BatteryMonitorService
//    private var bounded by mutableStateOf(false)


//    private val connector = BatteryServiceConnection(
//        onDisconnected = {
//            bounded = false
//        },
//        onConnected = {
//            batteryService = it
//            bounded = true
//        },
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPCAppTheme {


                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {


                    Button(
                        onClick = {
                            goToActivity(MessengerActivity::class.java)
                        },
                    ) {

                        Text(
                            text = "Go to messenger Activity",
                        )
                    }
                }
//                BatterServiceScreen(
//                    isBound = bounded,
//                    startMonitoring = { batteryService.startMonitoringBattery() },
//                    stopMonitoring = { batteryService.stopMonitoringBattery() },
//                    checkBatteryLevel = { batteryService.getCurrentBatteryLevel() }
//                )
            }
        }

    }

//    override fun onStart() {
//        super.onStart()
//        Intent(
//            this, BatteryMonitorService::class.java,
//        ).also { intent ->
//            bindService(intent, connector, Context.BIND_AUTO_CREATE)
//        }
//    }
//
//    override fun onStop() {
//        super.onStop()
//        unbindService(connector)
//        bounded = false
//    }


    private fun goToActivity(activity: Class<*>) {
        Intent(this, activity).also {
            startActivity(it)
        }
    }
}


class BatteryServiceConnection(
    private val onConnected: (BatteryMonitorService) -> Unit,
    private val onDisconnected: () -> Unit,
) : ServiceConnection {

    override fun onServiceDisconnected(name: ComponentName?) = onDisconnected.invoke()

    override fun onServiceConnected(
        name: ComponentName?,
        service: IBinder?,
    ) {
        val binder = service as BatteryMonitorService.BatteryBinder
        onConnected.invoke(binder.getService())
    }


}
