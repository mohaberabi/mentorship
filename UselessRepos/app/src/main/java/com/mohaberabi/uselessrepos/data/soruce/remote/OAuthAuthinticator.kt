package com.mohaberabi.uselessrepos.data.soruce.remote

import com.mohaberabi.uselessrepos.domain.source.local.TokenProvider

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class OAuthAuthinticator(
    private val tokenProvider: TokenProvider,
) : Authenticator {
    override fun authenticate(
        route: Route?,
        response: Response,
    ): Request {
        val refresh = tokenProvider.getRefreshToken()
        return response.request.newBuilder()
            .header("Authorization", "Bearer ${refresh}")
            .build()
    }

}