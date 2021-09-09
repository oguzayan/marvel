package com.ayanoguz.marvel.util

import android.content.Context
import com.ayanoguz.marvel.R
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class TokenInterceptor(val context: Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val publicKey = context.getString(R.string.public_key)
        val privateKey = context.getString(R.string.private_key)
        val ts = Date().time.toString()
        val hash = getHash(ts + privateKey + publicKey)
        val request = chain.request()
        val url = request.url
        val modifiedUrl = url.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()


        val response = request.newBuilder().url(modifiedUrl)
        val modifiedRequest = response.build()

        return chain.proceed(modifiedRequest)
    }

    private fun getHash(key: String): String {
        val md = MessageDigest.getInstance("MD5")
        val bigInt = BigInteger(1, md.digest(key.toByteArray(Charsets.UTF_8)))
        return String.format("%032x", bigInt)
    }
}