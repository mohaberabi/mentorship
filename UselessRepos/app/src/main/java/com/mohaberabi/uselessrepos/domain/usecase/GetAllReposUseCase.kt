package com.mohaberabi.uselessrepos.domain.usecase

import com.mohaberabi.uselessrepos.domain.repository.GithubRepoRepository

class GetAllReposUseCase(
    private val githubRepoRepository: GithubRepoRepository
) {
    suspend operator fun invoke(username: String = "mohaberabi") =
        githubRepoRepository.getAllRepos(username = username)
}