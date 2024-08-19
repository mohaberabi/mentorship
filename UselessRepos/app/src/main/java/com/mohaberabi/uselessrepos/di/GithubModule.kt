package com.mohaberabi.uselessrepos.di

import com.mohaberabi.uselessrepos.data.repository.DefaultGithubRepoRepository
import com.mohaberabi.uselessrepos.data.soruce.remote.RetrofitGithubRepoRemoteDataSource
import com.mohaberabi.uselessrepos.domain.repository.GithubRepoRepository
import com.mohaberabi.uselessrepos.domain.source.remote.GithubRepoRemoteDataSource
import com.mohaberabi.uselessrepos.domain.usecase.GetAllReposUseCase

interface GithubModule {


    val githubRepo: GithubRepoRepository
    val getAllReposUseCase: GetAllReposUseCase
    val githubRepoRemoteDataSource: GithubRepoRemoteDataSource
}


class GithubModuleImpl(
    private val appModule: AppModule,
) : GithubModule {
    override val githubRepoRemoteDataSource: GithubRepoRemoteDataSource
            by lazy { RetrofitGithubRepoRemoteDataSource(appModule.githubApi) }
    override val githubRepo: GithubRepoRepository
            by lazy { DefaultGithubRepoRepository(githubRepoRemoteDataSource) }
    override val getAllReposUseCase: GetAllReposUseCase
            by lazy {
                GetAllReposUseCase(githubRepo)
            }
}