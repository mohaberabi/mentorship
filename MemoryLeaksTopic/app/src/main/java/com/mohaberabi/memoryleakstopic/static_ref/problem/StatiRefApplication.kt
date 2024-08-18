package com.mohaberabi.memoryleakstopic.static_ref.problem

import android.app.Application
import android.content.Context

class StatiRefApplication :Application() {



    companion object {
        var myContext:Context?=null
    }

    override fun onCreate() {
        super.onCreate()
        myContext=this
    }
}