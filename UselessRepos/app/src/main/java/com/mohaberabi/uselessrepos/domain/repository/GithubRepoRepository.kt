package com.mohaberabi.uselessrepos.domain.repository

import com.mohaberabi.uselessrepos.domain.model.GithubRepo

interface GithubRepoRepository {
    suspend fun getAllRepos(
        username: String = "mohaberabi",
    ): Result<List<GithubRepo>>
}