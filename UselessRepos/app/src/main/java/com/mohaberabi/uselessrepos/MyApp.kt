package com.mohaberabi.uselessrepos

import android.app.Application
import com.mohaberabi.uselessrepos.di.AppModule
import com.mohaberabi.uselessrepos.di.AppModuleImpl
import com.mohaberabi.uselessrepos.di.GithubModule
import com.mohaberabi.uselessrepos.di.GithubModuleImpl


class MyApp : Application() {

    companion object {
        private lateinit var appModule: AppModule
        lateinit var githubModule: GithubModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl()
        githubModule = GithubModuleImpl(appModule)
    }
}