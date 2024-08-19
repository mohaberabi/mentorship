package com.mohaberabi.uselessrepos.data.repository

import com.mohaberabi.uselessrepos.domain.model.GithubRepo
import com.mohaberabi.uselessrepos.domain.repository.GithubRepoRepository
import com.mohaberabi.uselessrepos.domain.source.remote.GithubRepoRemoteDataSource

class DefaultGithubRepoRepository(
    private val remoteDataSource: GithubRepoRemoteDataSource,
) : GithubRepoRepository {
    override suspend fun getAllRepos(username: String): Result<List<GithubRepo>> {

        return try {
            val repos = remoteDataSource.getAllRepos(username = username)
            Result.success(repos)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}