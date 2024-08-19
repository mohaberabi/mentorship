package com.mohaberabi.uselessrepos.domain.source.local


interface TokenProvider {
    fun getRefreshToken(): String
    fun setAccessToken(value: String)
}