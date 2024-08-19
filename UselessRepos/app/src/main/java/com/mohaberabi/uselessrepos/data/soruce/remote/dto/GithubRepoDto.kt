package com.mohaberabi.uselessrepos.data.soruce.remote.dto

import com.google.gson.annotations.SerializedName
import com.mohaberabi.uselessrepos.domain.model.GithubRepo


data class GithubRepoDto(
    val id: Long,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val description: String?,
    @SerializedName("html_url")
    val htmlUrl: String
)


fun GithubRepoDto.toGithubRepo() = GithubRepo(
    id = id,
    name = name,
    fullName = fullName,
    description = description,
    htmlUrl = htmlUrl
)