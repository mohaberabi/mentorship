package com.mohaberabi.memoryleakstopic.anonymus_class

import android.os.Bundle
import androidx.activity.ComponentActivity
import java.lang.ref.WeakReference


class AnonymusClassSolution : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val weakReference = WeakReference(this)


        someLongRunningTask {
            weakReference.get()?.let {

            }
        }

        super.onCreate(savedInstanceState)
    }

    private fun someLongRunningTask(callback: () -> Unit) {
        Thread {
            Thread.sleep(60000)
            runOnUiThread(callback)
        }.start()
    }
}