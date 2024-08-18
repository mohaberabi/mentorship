package com.mohaberabi.memoryleakstopic.context_leaks

import android.content.Context
import androidx.activity.ComponentActivity

class MyManagerSolution(
    private val context: Context,
) {
    fun init() {

    
    }
}


class ActivityManagesSolution : ComponentActivity() {
    val manager = MyManagerSolution(applicationContext).also { it.init() }
}