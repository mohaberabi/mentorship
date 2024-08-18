package com.mohaberabi.memoryleakstopic.inner_class

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.activity.ComponentActivity
import java.lang.ref.WeakReference

class InnerClassSolution : ComponentActivity() {


    private var handler = MyHandler(this)

    private class MyHandler(activity: InnerClassSolution) : Handler(
        Looper.getMainLooper(),
    ) {
        private val activityReference = WeakReference(activity)
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val activity = activityReference.get()
            activity?.let {
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler.postDelayed(
            {

            },
            60000
        )
    }

}