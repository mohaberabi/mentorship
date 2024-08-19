package com.mohaberabi.uselessrepos.data.soruce.remote

import com.mohaberabi.uselessrepos.data.soruce.remote.dto.GithubRepoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepoServices {
    @GET("users/{username}/repos")
    suspend fun getAllRepos(
        @Path("username") username: String,
    ): List<GithubRepoDto>
}