package com.pustovit.vkclient.data_source_impl.service

import android.util.Log
import com.pustovit.vkclient.models.build.BuildSettings
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:31
 */
class BaseAuthInterceptor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val buildSettings: BuildSettings,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        Log.d("TAG", "auth intercept on thread ${Thread.currentThread().name}")
        val originalRequest = chain.request()

        val urlWithApiVersion = originalRequest.url.newBuilder()
            .addQueryParameter("v", buildSettings.apiVersion)
            .build()

        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer ${authLocalDataSource.getVkAccessToken()?.token}")
            .url(urlWithApiVersion)
            .build()

        chain.proceed(authenticatedRequest)
    }
}