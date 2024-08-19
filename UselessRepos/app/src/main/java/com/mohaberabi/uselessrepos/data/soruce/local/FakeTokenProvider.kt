package com.mohaberabi.uselessrepos.data.soruce.local

import com.mohaberabi.uselessrepos.domain.source.local.TokenProvider


class FakeTokenProvider : TokenProvider {
    override fun getRefreshToken(): String = "fake"

    override fun setAccessToken(value: String) {
    }

}