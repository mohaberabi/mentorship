package com.mohaberabi.memoryleakstopic.inner_class

import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity


class InnerClassProblem : ComponentActivity() {


    private val handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler.postDelayed({}, 60000)
    }
}