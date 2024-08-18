package com.mohaberabi.memoryleakstopic.context_leaks

import android.content.Context
import androidx.activity.ComponentActivity

class MyManager {
    private var context: Context? = null
    fun init(context: Context) {
        this.context = context
    }
}


class ActivityManagesProblem : ComponentActivity() {
    val manager = MyManager().also { it.init(this) }
}