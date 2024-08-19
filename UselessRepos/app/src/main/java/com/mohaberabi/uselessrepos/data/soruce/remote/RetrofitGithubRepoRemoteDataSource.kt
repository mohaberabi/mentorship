package com.mohaberabi.uselessrepos.data.soruce.remote

import com.mohaberabi.uselessrepos.data.soruce.remote.dto.toGithubRepo
import com.mohaberabi.uselessrepos.domain.model.GithubRepo
import com.mohaberabi.uselessrepos.domain.source.remote.GithubRepoRemoteDataSource

class RetrofitGithubRepoRemoteDataSource(
    private val api: GithubRepoServices
) : GithubRepoRemoteDataSource {
    override suspend fun getAllRepos(username: String): List<GithubRepo> =
        api.getAllRepos(username).map { it.toGithubRepo() }
}