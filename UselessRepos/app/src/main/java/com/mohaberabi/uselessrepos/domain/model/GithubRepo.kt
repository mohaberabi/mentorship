package com.mohaberabi.uselessrepos.domain.model


data class GithubRepo(
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String?,
    val htmlUrl: String

)