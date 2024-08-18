package com.mohaberabi.ipcapp.binder

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class BatteryMonitorService : Service() {

    private val binder = BatteryBinder()

    private lateinit var batteryJob: Job
    private var currentBatteryLevel = -1

    inner class BatteryBinder : Binder() {
        fun getService(): BatteryMonitorService = this@BatteryMonitorService
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onDestroy() {
        super.onDestroy()
        stopMonitoringBattery()
    }


    fun startMonitoringBattery() {
        batteryJob = CoroutineScope(
            Dispatchers.IO,
        ).launch {
            while (isActive) {
                val status: Intent? = IntentFilter(
                    Intent.ACTION_BATTERY_CHANGED,
                ).let {
                    applicationContext.registerReceiver(null, it)
                }
                currentBatteryLevel =
                    status?.getIntExtra(
                        BatteryManager.EXTRA_LEVEL, -1,
                    ) ?: -1
                delay(6000)
            }
        }
    }

    fun stopMonitoringBattery() = batteryJob.cancel()

    fun getCurrentBatteryLevel(): Int = currentBatteryLevel
}