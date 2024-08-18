package com.mohaberabi.memoryleakstopic.view_leaks

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity


class ViewLeaksProblem : ComponentActivity() {

    private var text: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        text= findViewById()
//        val s = text?.text.toString()

    }

    // this is solution

    override fun onDestroy() {
        super.onDestroy()
        text = null
    }
}