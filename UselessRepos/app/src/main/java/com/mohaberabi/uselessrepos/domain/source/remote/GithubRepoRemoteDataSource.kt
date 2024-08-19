package com.mohaberabi.uselessrepos.domain.source.remote

import com.mohaberabi.uselessrepos.domain.model.GithubRepo


interface GithubRepoRemoteDataSource {

    suspend fun getAllRepos(
        username: String = "mohaberabi",
    ): List<GithubRepo>
}