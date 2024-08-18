package com.mohaberabi.memoryleakstopic.static_ref.problem

import android.app.Application
import android.content.Context


class StaticRefSolutionApplication : Application() {


    companion object {
        private var myContext: Context? = null

        fun getContext(): Context? {
            return myContext
        }
    }


    override fun onCreate() {
        super.onCreate()
        myContext = applicationContext
    }


}