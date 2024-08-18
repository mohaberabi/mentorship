package com.mohaberabi.memoryleakstopic.anonymus_class

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlin.concurrent.thread


class AnonymusClassProblem : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        someLongTask {
            Log.i("bad", "Very bad task ")
        }
    }


    private fun someLongTask(callback: () -> Unit) {
        thread {
            Thread.sleep(600000)
            runOnUiThread(callback)
        }.start()
    }
}