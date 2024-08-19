package com.mohaberabi.uselessrepos.presentation.viewmodel

import com.mohaberabi.uselessrepos.domain.model.GithubRepo


enum class GithubStatus {
    Initial,
    Loading,
    Error,
    Populated
}

data class GithubState(
    val repos: List<GithubRepo> = listOf(),
    val state: GithubStatus = GithubStatus.Initial
)
