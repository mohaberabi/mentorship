package com.mohaberabi.uselessrepos.di

import android.content.Context
import com.mohaberabi.uselessrepos.data.repository.DefaultGithubRepoRepository
import com.mohaberabi.uselessrepos.data.soruce.local.FakeTokenProvider
import com.mohaberabi.uselessrepos.data.soruce.remote.GithubRepoServices
import com.mohaberabi.uselessrepos.data.soruce.remote.OAuthAuthinticator
import com.mohaberabi.uselessrepos.data.soruce.remote.RetrofitGithubRepoRemoteDataSource
import com.mohaberabi.uselessrepos.domain.repository.GithubRepoRepository
import com.mohaberabi.uselessrepos.domain.usecase.GetAllReposUseCase
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppModule {

    val githubApi: GithubRepoServices
}

class AppModuleImpl(
) : AppModule {

    private val tokenProvider = FakeTokenProvider()
    private val authinticator = OAuthAuthinticator(tokenProvider)
    private val authinticatorClient = OkHttpClient.Builder()
        .authenticator(authinticator)
        .build()
    override val githubApi: GithubRepoServices
        get() = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(authinticatorClient)
            .build().create(GithubRepoServices::class.java)

}