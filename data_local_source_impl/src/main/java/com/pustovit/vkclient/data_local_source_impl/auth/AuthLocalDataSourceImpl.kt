package com.pustovit.vkclient.data_local_source_impl.auth


import android.content.SharedPreferences
import com.pustovit.vkclient.data_local_api.auth.AuthLocalDataSource
import com.pustovit.vkclient.models.auth.VkAccessToken

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:13
 */
internal class AuthLocalDataSourceImpl(private val sharedPreferences: SharedPreferences) :
    AuthLocalDataSource {
    override suspend fun getVkAccessToken(): VkAccessToken? {
        return null
    }

    override suspend fun saveVkAccessToken(token: VkAccessToken) {

    }
}